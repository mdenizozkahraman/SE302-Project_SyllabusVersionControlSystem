import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GraphicalUserInterface extends JFrame {
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

        JLabel currentVersion = new JLabel("Current Syllabus");
        currentVersion.setHorizontalAlignment(SwingConstants.CENTER);
        currentVersion.setVerticalAlignment(SwingConstants.CENTER);
        currentVersion.setBounds(100, 50, 500, 600);
        currentVersion.setBorder(BorderFactory.createEtchedBorder());
        f.add(currentVersion, BorderLayout.CENTER);

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
                           // displaySearchResults(resultSet);
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error executing search query: " + ex.getMessage());
                    }
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = JOptionPane.showInputDialog("Enter Course Name:");
                String courseCode = JOptionPane.showInputDialog("Enter Course Code:");
                String semester = JOptionPane.showInputDialog("Enter Semester:");
                String theoryHourStr = JOptionPane.showInputDialog("Enter Theory Hour:");
                int theoryHour = Integer.parseInt(theoryHourStr);
                String labHourStr = JOptionPane.showInputDialog("Enter Lab Hour:");
                int labHour = Integer.parseInt(labHourStr);
                String localCreditStr = JOptionPane.showInputDialog("Enter Local Credit:");
                int localCredit = Integer.parseInt(localCreditStr);
                String ectsStr = JOptionPane.showInputDialog("Enter ECTS:");
                int ects = Integer.parseInt(ectsStr);
                Syllabus newSyllabus = new Syllabus(
                        1, courseName, courseCode, semester, theoryHour, labHour, localCredit, ects,
                        new Assessment(), new CourseOutcome(), new GeneralInformation(),
                        new WeeklySubjects(), new WorkLoad()
                );

                try (Connection connection = DriverManager.getConnection(url)) {
                    String addQuery = "INSERT INTO syllabus_table " +
                            "(courseName, courseCode, semester, theoryHour, labHour, localCredit, ects, assessment, courseOutcome, generalInformation, weeklySubjects, workLoad) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(addQuery)) {
                        preparedStatement.setString(1, newSyllabus.getCourseName());
                        preparedStatement.setString(2, newSyllabus.getCourseCode());
                        preparedStatement.setString(3, newSyllabus.getSemester());
                        preparedStatement.setInt(4, newSyllabus.getTheoryHour());
                        preparedStatement.setInt(5, newSyllabus.getLabHour());
                        preparedStatement.setInt(6, newSyllabus.getLocalCredit());
                        preparedStatement.setInt(7, newSyllabus.getEcts());
                        preparedStatement.setObject(8, newSyllabus.getAssessment());
                        preparedStatement.setObject(9, newSyllabus.getCourseOutcome());
                        preparedStatement.setObject(10, newSyllabus.getGeneralInformation());
                        preparedStatement.setObject(11, newSyllabus.getWeeklySubjects());
                        preparedStatement.setObject(12, newSyllabus.getWorkLoad());

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("New syllabus added successfully!");
                            // Ekleme başarılıysa kullanıcıya bildirim verilebilir veya eklenen bilgiler gösterilebilir
                        } else {
                            System.out.println("Failed to add new syllabus!");
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error adding new syllabus: " + ex.getMessage());
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
    private static void displaySearchResults(ResultSet resultSet, JLabel currentVersion) throws SQLException {
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
}



