import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GraphicalUserInterface extends JFrame {
    private static JTextArea currentVersion;
    private Connection con;

    public static void main(String[] args) {
        JFrame f = new JFrame("SYLLABUS APP");
        JTextArea searchBar;
        JButton searchBtn, addBtn, editBtn, deleteBtn, saveBtn, previousVersionsBtn;

        searchBar = new JTextArea();
        searchBar.setBounds(200, 10, 350, 25);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(555, 10, 100, 25);
        addBtn = new JButton("Add");
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");
        saveBtn = new JButton("Save");
        previousVersionsBtn = new JButton("<html>Previous<br/>Versions</html>");

        f.add(searchBtn);
        f.add(addBtn);
        f.add(editBtn);
        f.add(deleteBtn);
        f.add(saveBtn);
        f.add(previousVersionsBtn);
        f.add(searchBar);

        currentVersion = new JTextArea("Current Syllabus");
        currentVersion.setEditable(false); // Initially, set as not editable
        currentVersion.setWrapStyleWord(true);
        currentVersion.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(currentVersion);
        scrollPane.setBounds(100, 50, 500, 600);
        f.add(scrollPane);

        String url = "jdbc:sqlite:SyllabusDB.db";

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchBar.getText().trim();
                if (!searchText.isEmpty()) {
                    try (Connection connection = DriverManager.getConnection(url)) {
                        String searchQuery = "SELECT * FROM syllabus_table WHERE courseName LIKE ?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
                            preparedStatement.setString(1, "%" + searchText + "%");
                            ResultSet resultSet = preparedStatement.executeQuery();
                            displaySearchResults(resultSet, currentVersion);
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error executing search query: " + ex.getMessage());
                    }
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JDialog dialog = new JDialog();
                dialog.setTitle("Add New Syllabus");
                dialog.setSize(300, 300);
                dialog.setLayout(new GridLayout(8, 2, 10, 10));

                JTextField courseNameField = new JTextField();
                JTextField courseCodeField = new JTextField();
                JTextField semesterField = new JTextField();
                JTextField theoryHourField = new JTextField();
                JTextField labHourField = new JTextField();
                JTextField localCreditField = new JTextField();
                JTextField ectsField = new JTextField();

                dialog.add(new JLabel("Course Name:"));
                dialog.add(courseNameField);
                dialog.add(new JLabel("Course Code:"));
                dialog.add(courseCodeField);
                dialog.add(new JLabel("Semester:"));
                dialog.add(semesterField);
                dialog.add(new JLabel("Theory Hour:"));
                dialog.add(theoryHourField);
                dialog.add(new JLabel("Lab Hour:"));
                dialog.add(labHourField);
                dialog.add(new JLabel("Local Credit:"));
                dialog.add(localCreditField);
                dialog.add(new JLabel("ECTS:"));
                dialog.add(ectsField);

                JButton saveButton = new JButton("Save");
                saveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String courseName = courseNameField.getText();
                        String courseCode = courseCodeField.getText();
                        String semester = semesterField.getText();
                        int theoryHour = Integer.parseInt(theoryHourField.getText());
                        int labHour = Integer.parseInt(labHourField.getText());
                        int localCredit = Integer.parseInt(localCreditField.getText());
                        int ects = Integer.parseInt(ectsField.getText());

                        Syllabus newSyllabus = new Syllabus(
                                1, courseName, courseCode, semester, theoryHour, labHour, localCredit, ects,
                                new Assessment(), new CourseOutcome(), new GeneralInformation(),
                                new WeeklySubjects(), new WorkLoad()
                        );

                        dialog.dispose();
                    }
                });

                dialog.add(saveButton);
                dialog.setVisible(true);
            }
        });

        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Current Syllabus".equals(currentVersion.getText())) {
                    currentVersion.setText("");
                }
                currentVersion.setEditable(!currentVersion.isEditable());
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentVersion.isEditable()) {
                    // If in edit mode, capture the edited text and save to the database
                    String editedText = currentVersion.getText();


                   String updateQuery = "UPDATE syllabus_table SET column_name = ? WHERE condition = ?";
                     try (Connection connection = DriverManager.getConnection(url);
                     PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                       preparedStatement.setString(1, editedText);
                       //preparedStatement.setString(2, condition);
                       int rowsAffected = preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        System.out.println("Error updating syllabus: " + ex.getMessage());
                    }
                    currentVersion.setEditable(false);
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseCodeToDelete = JOptionPane.showInputDialog(f, "Enter Course Code to Delete:");

                if (courseCodeToDelete != null && !courseCodeToDelete.isEmpty()) {
                    int confirmDelete = JOptionPane.showConfirmDialog(f, "Are you sure you want to delete the syllabus with course code: " + courseCodeToDelete + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                    if (confirmDelete == JOptionPane.YES_OPTION) {

                        String deleteQuery = "DELETE FROM syllabus_table WHERE courseCode = ?";
                        try (Connection connection = DriverManager.getConnection(url);
                             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                            preparedStatement.setString(1, courseCodeToDelete);
                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(f, "Syllabus with course code " + courseCodeToDelete + " deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(f, "Syllabus with course code " + courseCodeToDelete + " not found.");
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error deleting syllabus: " + ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please enter a valid course code to delete.");
                }
            }
        });

        previousVersionsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame previousVersionsFrame = new JFrame("Previous Versions");
                JButton btn1, btn2;
                btn1 = new JButton("Next");
                btn2 = new JButton("Previous");

                previousVersionsFrame.add(btn1);
                previousVersionsFrame.add(btn2);


                previousVersionsFrame.addComponentListener(new ComponentAdapter() {
                    public void componentResized(ComponentEvent e) {
                        int width = previousVersionsFrame.getContentPane().getWidth();
                        int height = previousVersionsFrame.getContentPane().getHeight();

                        btn1.setBounds(width - 150, 480, 100, 25);
                        btn2.setBounds(50, 480, 100, 25);

                        int labelWidth = (width - 150) / 2;
                        int labelHeight = height - 100;

                        JLabel previousVersionsLabel1 = new JLabel("Former Version");
                        previousVersionsLabel1.setBorder(BorderFactory.createEtchedBorder());

                        JLabel previousVersionsLabel2 = new JLabel("Current Version");
                        previousVersionsLabel2.setBorder(BorderFactory.createEtchedBorder());

                        JPanel panel = new JPanel(new GridLayout(1, 2));
                        panel.setBounds(50, 50, width - 100, height - 100);
                        panel.add(previousVersionsLabel1);
                        panel.add(previousVersionsLabel2);

                        previousVersionsFrame.add(panel);
                    }

                });
                previousVersionsFrame.setSize(600, 550);
                previousVersionsFrame.setLayout(null);
                previousVersionsFrame.setVisible(true);
            }
        });

        f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int width = f.getContentPane().getWidth();
                int height = f.getContentPane().getHeight();

                addBtn.setBounds(width - 150, 100, 100, 25);
                editBtn.setBounds(width - 150, 130, 100, 25);
                deleteBtn.setBounds(width - 150, 160, 100, 25);
                saveBtn.setBounds(width - 150, 625, 100, 25);
                previousVersionsBtn.setBounds(width - 150, 190, 100, 50);
            }
        });

        f.addWindowStateListener(new WindowAdapter() {
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    int width = f.getContentPane().getWidth();
                    int height = f.getContentPane().getHeight();

                    currentVersion.setBounds(100, 50, width - 200, height - 100);
                }
            }
        });

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private static void displaySearchResults(ResultSet resultSet, JTextArea currentVersion) throws SQLException {
        StringBuilder resultText = new StringBuilder("<html><body>");
        resultText.append("<h2>Search Results:</h2>");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String courseName = resultSet.getString("courseName");
            String courseCode = resultSet.getString("courseCode");
            String semester = resultSet.getString("semester");
            int theoryHour = resultSet.getInt("theoryHour");
            int labHour = resultSet.getInt("labHour");
            int localCredit = resultSet.getInt("localCredit");
            int ects = resultSet.getInt("ects");

            resultText.append("<b>ID:</b> ").append(id).append("<br>");
            resultText.append("<b>Course Name:</b> ").append(courseName).append("<br>");
            resultText.append("<b>Course Code:</b> ").append(courseCode).append("<br>");
            resultText.append("<b>Semester:</b> ").append(semester).append("<br>");
            resultText.append("<b>Theory Hour:</b> ").append(theoryHour).append("<br>");
            resultText.append("<b>Lab Hour:</b> ").append(labHour).append("<br>");
            resultText.append("<b>Local Credit:</b> ").append(localCredit).append("<br>");
            resultText.append("<b>ECTS:</b> ").append(ects).append("<br>");
            resultText.append("----------------------<br>");
        }

        resultText.append("</body></html>");
        currentVersion.setText(resultText.toString());
    }

    public static String currentDate(){
        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int minute = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR);

        if(hour < 10 ){
            return (day + "/" + (month+1)+ "/"+  + year + " " + "0" + hour +":" +minute);

        }
        else {
            return (day + "/" + (month+1)+ "/"+ year + " " + hour +":" +minute);

        }
    }
}



