import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GraphicalUserInterface {

    private void insert_GeneralInformation(String courseName, String courseCode, String semester, String theoryHour, String labHour, String localCredit, String ects,String prerequisites,String courseLanguage,String courseType,String courseLevel,String modeOfDelivery,String teachingMethod,String courseCoordinator,String courseLecturer,String assistant ,String courseObjectives, String learningOutcomes,String courseDescription,String courseCategory,String courseBook,String suggestedMaterials) {
        Connection con = SyllabusDB.connect();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO General_Information (courseName, courseCode, semester, theoryHour, labHour, localCredit, ects,prerequisites,courseLanguage,courseType,courseLevel,modeOfDelivery,teachingMethod,courseCoordinator,courseLecturer,assistant,courseObjectives,learningOutcomes,courseDescription,courseCategory,courseBook,suggestedMaterials) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.setString(2, courseCode);
            ps.setString(3, semester);
            ps.setString(4, theoryHour);
            ps.setString(5, labHour);
            ps.setString(6, localCredit);
            ps.setString(7, ects);
            ps.setString(8,prerequisites);
            ps.setString(9,courseLanguage);
            ps.setString(10,courseType);
            ps.setString(11,courseLevel);
            ps.setString(12,modeOfDelivery);
            ps.setString(13,teachingMethod);
            ps.setString(14,courseCoordinator);
            ps.setString(15,courseLecturer);
            ps.setString(16,assistant);
            ps.setString(17,courseObjectives);
            ps.setString(18,learningOutcomes);
            ps.setString(19,courseDescription);
            ps.setString(20,courseCategory);
            ps.setString(21,courseBook);
            ps.setString(22,suggestedMaterials);


            ps.execute();

            System.out.println("Data has been inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void AssessmentData(ArrayList<Assessment> assessmentArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (Assessment assessment : assessmentArrayList ){
                String semesterActivities = assessment.getSemesterActivities();
                int number  = assessment.getNumber();
                int weighting = assessment.getWeighting();
                int lo1 = assessment.getLo1();
                int lo2 = assessment.getLo2();
                int lo3 = assessment.getLo3();
                int lo4 = assessment.getLo4();



                insert_Assessment(con, semesterActivities, number, weighting, lo1, lo2, lo3, lo4);
            }
            System.out.println("All data has been inserted successfully!");

        }
        finally {
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }

    private void insert_Assessment(Connection con, String semesterActivities, int number,int weighting, int lo1, int lo2, int lo3, int lo4){
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO assessment(semesterActivities, number, weighting, lo1, lo2, lo3, lo4) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, semesterActivities );
            ps.setInt(2, number);
            ps.setInt(3, weighting);
            ps.setInt(4, lo1);
            ps.setInt(5, lo2);
            ps.setInt(6, lo3);
            ps.setInt(7, lo4);




            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null){
                    ps.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    /**
     *  OLD CODE
     * private void insert_Assesment(String semesterActivites,String number,String weighting,String lo1,String lo2,String lo3,String lo4 ) {
        Connection con = SyllabusDB.connect();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO assesment(semesterActivites,number,weighting,lo1,lo2,lo3,lo4) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, semesterActivites);
            ps.setString(2, number);
            ps.setString(3, weighting);
            ps.setString(4, lo1);
            ps.setString(5, lo2);
            ps.setString(6, lo3);
            ps.setString(7, lo4);


            ps.execute();

            System.out.println("Data has been inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }**/

    public void WeeklySubjectsData(ArrayList<WeeklySubjects> weeklySubjectsArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (WeeklySubjects weeklySubjects : weeklySubjectsArrayList){
                String subject = weeklySubjects.getSubject();
                String requiredMaterials = weeklySubjects.getRequiredMaterials();


                insert_WeeklySubject(con, subject, requiredMaterials);
            }
            System.out.println("All data has been inserted successfully!");

        }
        finally {
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    private void insert_WeeklySubject(Connection con, String subject, String requiredMaterials){
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO weeklySubjects(subject, requiredMaterials) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, subject);
            ps.setString(2, requiredMaterials);


            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null){
                    ps.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }

    public void CourseOutcomeData(ArrayList<CourseOutcome> courseOutcomeArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (CourseOutcome courseOutcome : courseOutcomeArrayList){
                int number  = courseOutcome.getNumber();
                String programCompetencies = courseOutcome.getProgramCompetencies();
                int contributionLevel[] = courseOutcome.getContributionLevel();


                insert_courseOutcome(con, number, programCompetencies, contributionLevel);
            }
            System.out.println("All data has been inserted successfully!");

        }
        finally {
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    private void insert_courseOutcome(Connection con, int number, String programCompetencies, int[] contributionLevel){
        PreparedStatement ps = null;

        try {

            String contributionLevelString = Arrays.stream(contributionLevel)
                    .mapToObj(String :: valueOf)
                    .collect(Collectors.joining(","));
            String sql = "INSERT INTO courseOutcome(number, programCompetencies, contributionLevel) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, number);
            ps.setString(2, programCompetencies);
            ps.setString(3, contributionLevelString);


            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null){
                    ps.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> GUI());
        SyllabusDB.connect();

    }

    private static void GUI() {
        JFrame frame = new JFrame("Syllabus Version Control Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = screenSize.width / 2;
        int height = screenSize.height / 3;
        frame.setSize(width, height);

        frame.setLayout(new GridBagLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JTextField searchText = new JTextField(30);
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton prevVersionsButton = new JButton("Previous Versions");
        JButton saveButton = new JButton("Save");

        JTextArea resultTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchText.getText();
                String searchResult = "Syllabus Form for: " + searchQuery + "\nDetails...\n";
                resultTextArea.setText(searchResult);
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddForm();
            }
        });



        topPanel.add(searchText);
        topPanel.add(searchButton);
        topPanel.add(addButton);
        topPanel.add(editButton);
        topPanel.add(deleteButton);
        topPanel.add(prevVersionsButton);
        topPanel.add(saveButton);


        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.weightx = 1.0;
        gbcTopPanel.fill = GridBagConstraints.HORIZONTAL;
        frame.add(topPanel, gbcTopPanel);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 500, 20, 500));

        GridBagConstraints gbcBottomPanel = new GridBagConstraints();
        gbcBottomPanel.gridx = 0;
        gbcBottomPanel.gridy = 1;
        gbcBottomPanel.weightx = 1.0;
        gbcBottomPanel.weighty = 1.0;
        gbcBottomPanel.fill = GridBagConstraints.BOTH;
        frame.add(bottomPanel, gbcBottomPanel);

        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpMenuItem = new JMenuItem("Help");


        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Help Content");
            }
        });

        helpMenu.add(helpMenuItem);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private static void showAddForm() {
        JFrame addFrame = new JFrame("Add Syllabus");
        addFrame.setSize(1000, 1000);
        addFrame.setLocationRelativeTo(null);


        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel generalInfoPanel = new JPanel();
        generalInfoPanel.setLayout(new GridLayout(24, 2));
        generalInfoPanel.add(new JLabel("Course Name:"));
        JTextField courseNameField = new JTextField();
        generalInfoPanel.add(courseNameField);

        generalInfoPanel.add(new JLabel("Course Code:"));
        JTextField courseCodeField = new JTextField();
        generalInfoPanel.add(courseCodeField);

        generalInfoPanel.add(new JLabel("Semester:"));
        JTextField semesterField = new JTextField();
        generalInfoPanel.add(semesterField);

        generalInfoPanel.add(new JLabel("Theory:"));
        JTextField theoryField = new JTextField();
        generalInfoPanel.add(theoryField);

        generalInfoPanel.add(new JLabel("Application Lab:"));
        JTextField applicationLabField = new JTextField();
        generalInfoPanel.add(applicationLabField);

        generalInfoPanel.add(new JLabel("Local Credits:"));
        JTextField localCreditsField = new JTextField();
        generalInfoPanel.add(localCreditsField);

        generalInfoPanel.add(new JLabel("ECTS:"));
        JTextField ECTSField = new JTextField();
        generalInfoPanel.add(ECTSField);

        generalInfoPanel.add(new JLabel("Prerequisites:"));
        JTextField prerequisitesField = new JTextField();
        generalInfoPanel.add(prerequisitesField);

        generalInfoPanel.add(new JLabel("Course Language:"));
        JTextField courseLanguageField = new JTextField();
        generalInfoPanel.add(courseLanguageField);

        generalInfoPanel.add(new JLabel("Course Type:"));
        JTextField courseTypeField = new JTextField();
        generalInfoPanel.add(courseTypeField);

        generalInfoPanel.add(new JLabel("Course Level:"));
        JTextField courseLevelField = new JTextField();
        generalInfoPanel.add(courseLevelField);

        generalInfoPanel.add(new JLabel("Mode of Delivery:"));
        JTextField modeOfDeliveryField = new JTextField();
        generalInfoPanel.add(modeOfDeliveryField);

        generalInfoPanel.add(new JLabel("Teaching Methods:"));
        JTextField teachingMethodsField = new JTextField();
        generalInfoPanel.add(teachingMethodsField);

        generalInfoPanel.add(new JLabel("Course Coordinator:"));
        JTextField courseCoordinatorField = new JTextField();
        generalInfoPanel.add(courseCoordinatorField);

        generalInfoPanel.add(new JLabel("Course Lecturers:"));
        JTextField courseLecturersField = new JTextField();
        generalInfoPanel.add(courseLecturersField);

        generalInfoPanel.add(new JLabel("Assistants:"));
        JTextField assistantsField = new JTextField();
        generalInfoPanel.add(assistantsField);

        generalInfoPanel.add(new JLabel("Course Objectives:"));
        JTextField courseObjectivesField = new JTextField();
        generalInfoPanel.add(courseObjectivesField);

        generalInfoPanel.add(new JLabel("Learning Outcomes:"));
        JTextField learningOutcomesField = new JTextField();
        generalInfoPanel.add(learningOutcomesField);

        generalInfoPanel.add(new JLabel("Course Description:"));
        JTextField courseDescriptionField = new JTextField();
        generalInfoPanel.add(courseDescriptionField);

        generalInfoPanel.add(new JLabel("Course Category:"));
        JTextField courseCategoryField = new JTextField();
        generalInfoPanel.add(courseCategoryField);

        generalInfoPanel.add(new JLabel("Course Notes:"));
        JTextField courseNotesField = new JTextField();
        generalInfoPanel.add(courseNotesField);

        generalInfoPanel.add(new JLabel("Suggested Materials:"));
        JTextField suggestedMaterialsField = new JTextField();
        generalInfoPanel.add(suggestedMaterialsField);


        JPanel weeklySubjectsPanel = new JPanel();
        weeklySubjectsPanel.setLayout(new GridLayout(16, 2));

        ArrayList<JTextField> jTextSubjectFieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextMaterialFieldArrayList = new ArrayList<>();

        for (int week = 1; week <= 16; week++) {
            weeklySubjectsPanel.add(new JLabel("Week " + week + " Subjects:"));
            JTextField subjectsField = new JTextField();
            weeklySubjectsPanel.add(subjectsField);

            jTextSubjectFieldArrayList.add(subjectsField);

            weeklySubjectsPanel.add(new JLabel("Week " + week + " Materials:"));
            JTextField materialsField = new JTextField();
            weeklySubjectsPanel.add(materialsField);

            jTextMaterialFieldArrayList.add(materialsField);

            if (week == 15) {
                subjectsField.setText("Semester Review");
            }

            if (week == 16) {
                subjectsField.setText("Final Exam");
            }


        }



        JPanel assesmentPanel = new JPanel();
        assesmentPanel.setLayout(new GridLayout(13, 6));

        for (int row = 1; row <= 13; row++) {

            String[] semesterActivities = {
                    "Participation",
                    "Laboratory/Application",
                    "Field Work",
                    "Quiz/Studio Critique",
                    "Homework/Assignment",
                    "Presentation/Jury",
                    "Project",
                    "Portfolio",
                    "Seminar/Workshop",
                    "Oral Exam",
                    "Midterm",
                    "Final Exam",
                    "Total"
            };

            JLabel semesterActivityLabel = new JLabel("Semester Activity " + row + ":");
            JTextField semesterActivityField = new JTextField();

            semesterActivityField.setText(semesterActivities[row-1]);


            JLabel numberLabel = new JLabel("Number " + row + ":");
            JTextField numberField = new JTextField();
            JLabel weightingLabel = new JLabel("Weighting " + row + ":");
            JTextField weightingField = new JTextField();
            JLabel lo1Label = new JLabel("LO1 " + row + ":");
            JTextField lo1Field = new JTextField();
            JLabel lo2Label = new JLabel("LO2 " + row + ":");
            JTextField lo2Field = new JTextField();
            JLabel lo3Label = new JLabel("LO3 " + row + ":");
            JTextField lo3Field = new JTextField();
            JLabel lo4Label = new JLabel("LO4 " + row + ":");
            JTextField lo4Field = new JTextField();

            assesmentPanel.add(semesterActivityLabel);
            assesmentPanel.add(semesterActivityField);
            assesmentPanel.add(numberLabel);
            assesmentPanel.add(numberField);
            assesmentPanel.add(weightingLabel);
            assesmentPanel.add(weightingField);
            assesmentPanel.add(lo1Label);
            assesmentPanel.add(lo1Field);
            assesmentPanel.add(lo2Label);
            assesmentPanel.add(lo2Field);
            assesmentPanel.add(lo3Label);
            assesmentPanel.add(lo3Field);
            assesmentPanel.add(lo4Label);
            assesmentPanel.add(lo4Field);

        }

        JPanel ectsWorkloadPanel = new JPanel();
        ectsWorkloadPanel.setLayout(new GridLayout(14, 4));

        for (int row = 1; row <= 14; row++) {

            String[] semesterActivities = {
                    "Course Hours",
                    "Laboratory/Application Hours",
                    "Study Hours out of Class",
                    "Field Work",
                    "Quiz/Studio Critique",
                    "Homework/Assignments",
                    "Presentation/Jury",
                    "Project",
                    "Portfolio",
                    "Seminar/Workshop",
                    "Oral Exam",
                    "Midterm",
                    "Final Exam",
                    "Total"
            };

            JLabel semesterActivityLabel = new JLabel("Semester Activity " + row + ":");
            JTextField semesterActivityField = new JTextField();

            semesterActivityField.setText(semesterActivities[row-1]);

            JLabel numberLabel = new JLabel("Number " + row + ":");
            JTextField numberField = new JTextField();
            JLabel durationLabel = new JLabel("Duration " + row + ":");
            JTextField durationField = new JTextField();
            JLabel workloadLabel = new JLabel("Workload " + row + ":");
            JTextField workloadField = new JTextField();

            if (row == 14){
                numberField.setText("");
                durationField.setText("");
                numberField.setEditable(false);
                durationField.setEditable(false);
            }

            ectsWorkloadPanel.add(semesterActivityLabel);
            ectsWorkloadPanel.add(semesterActivityField);
            ectsWorkloadPanel.add(numberLabel);
            ectsWorkloadPanel.add(numberField);
            ectsWorkloadPanel.add(durationLabel);
            ectsWorkloadPanel.add(durationField);
            ectsWorkloadPanel.add(workloadLabel);
            ectsWorkloadPanel.add(workloadField);
        }

        JPanel programOutcomePanel = new JPanel();
        programOutcomePanel.setLayout(new GridLayout(13, 3));

        for (int row = 1; row <= 13; row++) {

            String[] programCompetencies = {
                    "To have adequate knowledge in Mathematics, Science and Computer Engineering; to be able to use theoretical and applied information in these areas on complex engineering problems.",
                    "To be able to identify, define, formulate, and solve complex Computer Engineering problems; to be able to select and apply proper analysis and modeling methods for this purpose.",
                    "To be able to design a complex system, process, device or product under realistic constraints and conditions, in such a way as to meet the requirements; to be able to apply modern design methods for this purpose.",
                    "To be able to devise, select, and use modern techniques and tools needed for analysis and solution of complex problems in Computer Engineering applications; to be able to use information technologies effectively.",
                    "To be able to design and conduct experiments, gather data, analyze, and interpret results for investigating complex engineering problems or Computer Engineering research topics.",
                    "To be able to work efficiently in Computer Engineering disciplinary and multi-disciplinary teams; to be able to work individually.",
                    "To be able to communicate effectively in Turkish, both orally and in writing; to be able to author and comprehend written reports, to be able to prepare design and implementation reports, to present effectively, to be able to give and receive clear and comprehensible instructions.",
                    "To have knowledge about global and social impact of Computer Engineering practices on health, environment, and safety; to have knowledge about contemporary issues as they pertain to engineering; to be aware of the legal ramifications of Computer Engineering solutions.",
                    "To be aware of ethical behavior, professional and ethical responsibility; to have knowledge about standards utilized in engineering applications.",
                    "To have knowledge about industrial practices such as project management, risk management, and change management; to have awareness of entrepreneurship and innovation; to have knowledge about sustainable development.",
                    "To be able to collect data in the area of Computer Engineering, and to be able to communicate with colleagues in a foreign language (\"European Language Portfolio Global Scale\", Level B1)",
                    "To be able to speak a second foreign language at a medium level of fluency efficiently.",
                    "To recognize the need for lifelong learning; to be able to access information, to be able to stay current with developments in science and technology; to be able to relate the knowledge accumulated throughout the human history to Computer Engineering."
            };

            JLabel programCompetenciesLabel = new JLabel("Program Competencies " + row + ":");
            JTextField programCompetenciesField = new JTextField();

            programCompetenciesField.setText(programCompetencies[row-1]);

            JLabel contributionLevelLabel = new JLabel("Contribution Level " + row + ":");
            JTextField contributionLevelField = new JTextField();

            programOutcomePanel.add(programCompetenciesLabel);
            programOutcomePanel.add(programCompetenciesField);
            programOutcomePanel.add(contributionLevelLabel);
            programOutcomePanel.add(contributionLevelField);
        }

        tabbedPane.addTab("General Information", generalInfoPanel);
        tabbedPane.addTab("Weekly Subjects", weeklySubjectsPanel);
        tabbedPane.addTab("Assesment", assesmentPanel);
        tabbedPane.addTab("ECTS / Workload", ectsWorkloadPanel);
        tabbedPane.addTab("Course / Program Outcome", programOutcomePanel);


        addFrame.add(tabbedPane);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                String courseCode = courseCodeField.getText();
                String semester = semesterField.getText();
                String theoryHour = theoryField.getText();
                String labHour = applicationLabField.getText();
                String localCredit = localCreditsField.getText();
                String ects = ECTSField.getText();
                String prerequisites = prerequisitesField.getText();
                String courseLanguage = courseLanguageField.getText();
                String courseType = courseTypeField.getText();
                String courseLevel = courseLevelField.getText();
                String modeOfDelivery = modeOfDeliveryField.getText();
                String teachingMethod = teachingMethodsField.getText();
                String courseCoordinator = courseCoordinatorField.getText();
                String courseLecturer = courseLecturersField.getText();
                String assistant = assistantsField.getText();
                String courseObjectives = courseObjectivesField.getText();
                String learningOutcomes = learningOutcomesField.getText();
                String courseDescription = courseDescriptionField.getText();
                String courseCategory = courseCategoryField.getText();
                String courseBook = courseNotesField.getText();
                String suggestedMaterials = suggestedMaterialsField.getText();


                for (int i = 0; i < 16; i++){
                    System.out.println(jTextSubjectFieldArrayList.get(i).getText());
                    System.out.println(jTextMaterialFieldArrayList.get(i).getText());
                }


                GraphicalUserInterface gui = new GraphicalUserInterface();



               // gui.insert_GeneralInformation(courseName,courseCode,semester,theoryHour,labHour,localCredit,ects,prerequisites,courseLanguage,courseType,courseLevel,modeOfDelivery,teachingMethod,courseCoordinator,courseLecturer,assistant,courseObjectives,learningOutcomes,courseDescription,courseCategory,courseBook,suggestedMaterials);





                addFrame.dispose();
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked");

                addFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        addFrame.add(tabbedPane, BorderLayout.CENTER);
        addFrame.add(buttonPanel, BorderLayout.SOUTH);


        addFrame.setVisible(true);
    }

}

