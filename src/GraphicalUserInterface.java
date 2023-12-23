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

    static Assessment assessment = new Assessment();
    static CourseOutcome courseOutcome = new CourseOutcome();
    static GeneralInformation generalInformation = new GeneralInformation();
    static WeeklySubjects weeklySubjects = new WeeklySubjects();
    static WorkLoad workLoad = new WorkLoad();

    static Syllabus syllabus = new Syllabus(0,assessment,courseOutcome,generalInformation,weeklySubjects,workLoad);

    static JsonClass jsonClass = new JsonClass();


    private void deleteByCourseCode(String courseCode) {
        Connection con = SyllabusDB.connect();
        PreparedStatement psGeneral_Information = null;
        PreparedStatement psAssessments = null;
        PreparedStatement pscourse_Outcome = null;
        PreparedStatement psWeeklySubjects = null;
        PreparedStatement psEcts_Workload = null;


        try {


            String deleteEcts_Workload = "DELETE FROM Ects_Workload WHERE id IN (SELECT id FROM WeeklySubjects WHERE courseCode = ?)";
            psEcts_Workload = con.prepareStatement(deleteEcts_Workload);
            psEcts_Workload.setString(1,courseCode);
            psEcts_Workload.executeUpdate();


            String deleteWeeklySubjects = "DELETE FROM WeeklySubjects WHERE id IN (SELECT id From WeeklySubjets WHERE courseCode = ?";
            psWeeklySubjects = con.prepareStatement(deleteWeeklySubjects);
            psWeeklySubjects.setString(1,courseCode);
            psWeeklySubjects.executeUpdate();



            String deletecourse_Outcome = "DELETE FROM course_Outcome WHERE id IN (SELECT id FROM SyllabusDB WHERE courseCode = ?)";
            pscourse_Outcome = con.prepareStatement(deletecourse_Outcome);
            pscourse_Outcome.setString(1,courseCode);
            pscourse_Outcome.executeUpdate();

            String deleteAssessments = "DELETE FROM Assesments WHERE id IN (SELECT id FROM SyllabusDB WHERE courseCode = ?)";
            psAssessments = con.prepareStatement(deleteAssessments);
            psAssessments.setString(1, courseCode);
            psAssessments.executeUpdate();


            String deleteGeneral_Information = "DELETE FROM General_Information WHERE courseCode = ?";
            psGeneral_Information = con.prepareStatement(deleteGeneral_Information);
            psGeneral_Information.setString(1, courseCode);
            psGeneral_Information.executeUpdate();

            System.out.println("Data with Course Code: " + courseCode + " has been deleted successfully.");
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (psGeneral_Information != null) {
                    psGeneral_Information.close();
                }
                if (psAssessments != null) {
                    psAssessments.close();
                }
                if(pscourse_Outcome != null){
                    pscourse_Outcome.close();
                }
                if(psWeeklySubjects != null){
                    psWeeklySubjects.close();
                }
                if(psEcts_Workload != null){
                    psEcts_Workload.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }



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

    public void AssessmentData(ArrayList<JTextField> assessmentArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (JTextField assessment : assessmentArrayList ){
                String semesterActivities = assessment.getText();
                String number  = assessment.getText();
                String weighting = assessment.getText();
                String lo1 = assessment.getText();
                String lo2 = assessment.getText();
                String lo3 = assessment.getText();
                String lo4 = assessment.getText();


                System.out.println(semesterActivities);
                //insert_Assessment(con, semesterActivities, number, weighting, lo1, lo2, lo3, lo4);
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

    private void insert_Assessment(Connection con, String semesterActivities, String number,String weighting, String lo1, String lo2, String lo3, String lo4){
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO assessment(semesterActivities, number, weighting, lo1, lo2, lo3, lo4) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, semesterActivities );
            ps.setString(2, number);
            ps.setString(3, weighting);
            ps.setString(4, lo1);
            ps.setString(5, lo2);
            ps.setString(6, lo3);
            ps.setString(7, lo4);




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


    public void WeeklySubjectsData(ArrayList<JTextField> weeklySubjectsArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (JTextField weeklySubjects : weeklySubjectsArrayList){
                String subject = weeklySubjects.getText();
                String requiredMaterials = weeklySubjects.getText();

                System.out.println(subject); // ********* TEST this for other parts
                //insert_WeeklySubject(con, subject, requiredMaterials);
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

    public void CourseOutcomeData(ArrayList<JTextField> courseOutcomeArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (JTextField courseOutcome : courseOutcomeArrayList){
                String number  = courseOutcome.getText();
                String programCompetencies = courseOutcome.getText();
                String contributionLevel = courseOutcome.getText();

                System.out.println(programCompetencies);
                //insert_courseOutcome(con, number, programCompetencies, contributionLevel);
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
    private void insert_courseOutcome(Connection con, String number, String programCompetencies, String contributionLevel){
        PreparedStatement ps = null;

        try {


            String sql = "INSERT INTO courseOutcome(number, programCompetencies, contributionLevel) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, number);
            ps.setString(2, programCompetencies);
            ps.setString(3, contributionLevel);


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

    public void WorkLoadData(ArrayList<JTextField> workLoadArrayList){
        Connection con = SyllabusDB.connect();

        try {
            for (JTextField workLoad : workLoadArrayList){
                String semesterActivities  = workLoad.getText();
                String number = workLoad.getText();
                String duration = workLoad.getText();
                String workload = workLoad.getText();

                System.out.println(semesterActivities);
                //insert_workLoad(con, semesterActivities, number, duration, workload);
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
    private void insert_workLoad(Connection con,String semesterActivities,  String number, String duration, String workload){
        PreparedStatement ps = null;

        try {


            String sql = "INSERT INTO workLoad(semesterActivities, number, duration, workload) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, semesterActivities);
            ps.setString(1, number);
            ps.setString(2, duration);
            ps.setString(3, workload);


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

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog deleteDialog = new JDialog();
                deleteDialog.setTitle("Delete Syllabus");
                deleteDialog.setSize(500, 100);
                deleteDialog.setLocationRelativeTo(null);

                deleteDialog.setLayout(new GridLayout(1, 2));

                JTextField courseCodeField = new JTextField();

                deleteDialog.add(new JLabel("Course Code:"));
                deleteDialog.add(courseCodeField);

                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String courseCode = courseCodeField.getText();

                        GraphicalUserInterface gui = new GraphicalUserInterface();
                        gui.deleteByCourseCode(courseCode);

                        deleteDialog.dispose();
                    }
                });

                deleteDialog.add(deleteButton);
                deleteDialog.setVisible(true);

            }
        });

        prevVersionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddForm();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsonClass.json(syllabus);
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


        ArrayList<JTextField> jTextSemesterActivityFieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextNumberFieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextWeightingFieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextLO1FieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextLO2FieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextLO3FieldArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextLO4FieldArrayList = new ArrayList<>();



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

            jTextSemesterActivityFieldArrayList.add(semesterActivityField);
            jTextNumberFieldArrayList.add(numberField);
            jTextWeightingFieldArrayList.add(weightingField);
            jTextLO1FieldArrayList.add(lo1Field);
            jTextLO2FieldArrayList.add(lo2Field);
            jTextLO3FieldArrayList.add(lo3Field);
            jTextLO4FieldArrayList.add(lo4Field);

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

        ArrayList<JTextField> jTextSemesterActivityFieldCourseOutcomeArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextNumberFieldCourseOutcomeArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextDurationFieldCourseOutcomeArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextWorkloadFieldCourseOutcomeArrayList = new ArrayList<>();


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

            jTextSemesterActivityFieldCourseOutcomeArrayList.add(semesterActivityField);
            jTextNumberFieldCourseOutcomeArrayList.add(numberField);
            jTextDurationFieldCourseOutcomeArrayList.add(durationField);
            jTextWorkloadFieldCourseOutcomeArrayList.add(workloadField);

            ectsWorkloadPanel.add(semesterActivityLabel);
            ectsWorkloadPanel.add(semesterActivityField);
            ectsWorkloadPanel.add(numberLabel);
            ectsWorkloadPanel.add(numberField);
            ectsWorkloadPanel.add(durationLabel);
            ectsWorkloadPanel.add(durationField);
            ectsWorkloadPanel.add(workloadLabel);
            ectsWorkloadPanel.add(workloadField);
        }

        ArrayList<JTextField> jTextProgramCompetenciesArrayList = new ArrayList<>();
        ArrayList<JTextField> jTextContributionLevelArrayList = new ArrayList<>();


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

            jTextProgramCompetenciesArrayList.add(programCompetenciesField);
            jTextContributionLevelArrayList.add(contributionLevelField);


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
                syllabus.getGeneralInformation().setCourseName(courseNameField.getText());
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



                GraphicalUserInterface gui = new GraphicalUserInterface();

                System.out.println(syllabus.getGeneralInformation().getCourseName());

                gui.WeeklySubjectsData(jTextSubjectFieldArrayList);
                gui.WeeklySubjectsData(jTextMaterialFieldArrayList);
                System.out.println("------------------------------");
                gui.AssessmentData(jTextSemesterActivityFieldArrayList);
                gui.AssessmentData(jTextNumberFieldArrayList);
                gui.AssessmentData(jTextWeightingFieldArrayList);
                gui.AssessmentData(jTextLO1FieldArrayList);
                gui.AssessmentData(jTextLO2FieldArrayList);
                gui.AssessmentData(jTextLO3FieldArrayList);
                gui.AssessmentData(jTextLO4FieldArrayList);
                System.out.println("------------------------------");
                gui.WorkLoadData(jTextSemesterActivityFieldCourseOutcomeArrayList);
                gui.WorkLoadData(jTextNumberFieldCourseOutcomeArrayList);
                gui.WorkLoadData(jTextDurationFieldCourseOutcomeArrayList);
                gui.WorkLoadData(jTextWorkloadFieldCourseOutcomeArrayList);
                System.out.println("------------------------------");
                gui.CourseOutcomeData(jTextProgramCompetenciesArrayList);
                gui.CourseOutcomeData(jTextContributionLevelArrayList);


                //gui.insert_GeneralInformation(courseName,courseCode,semester,theoryHour,labHour,localCredit,ects,prerequisites,courseLanguage,courseType,courseLevel,modeOfDelivery,teachingMethod,courseCoordinator,courseLecturer,assistant,courseObjectives,learningOutcomes,courseDescription,courseCategory,courseBook,suggestedMaterials);





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

