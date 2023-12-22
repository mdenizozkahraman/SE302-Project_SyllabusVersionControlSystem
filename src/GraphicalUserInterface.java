import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUserInterface {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> GUI());
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

        for (int week = 1; week <= 16; week++) {
            weeklySubjectsPanel.add(new JLabel("Week " + week + " Subjects:"));
            JTextField subjectsField = new JTextField();
            weeklySubjectsPanel.add(subjectsField);

            weeklySubjectsPanel.add(new JLabel("Week " + week + " Materials:"));
            JTextField materialsField = new JTextField();
            weeklySubjectsPanel.add(materialsField);

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
                String theory = theoryField.getText();
                String applicationLab = applicationLabField.getText();
                String localCredits = localCreditsField.getText();
                String ECTS = ECTSField.getText();
                String prerequisites = prerequisitesField.getText();
                String courseLanguage = courseLanguageField.getText();
                String courseType = courseTypeField.getText();
                String courseLevel = courseLevelField.getText();
                String modeOfDelivery = modeOfDeliveryField.getText();
                String teachingMethods = teachingMethodsField.getText();
                String courseCoordinator = courseCoordinatorField.getText();
                String courseLecturers = courseLecturersField.getText();
                String assistants = assistantsField.getText();
                String courseObjectives = courseObjectivesField.getText();
                String learningOutcomes = learningOutcomesField.getText();
                String courseDescription = courseDescriptionField.getText();
                String courseCategory = courseCategoryField.getText();
                String courseNotes = courseNotesField.getText();
                String suggestedMaterials = suggestedMaterialsField.getText();

                System.out.println("Course Name: " + courseName);
                System.out.println("Course Code: " + courseCode);
                System.out.println("Semester: " + semester);
                System.out.println("Theory: " + theory);
                System.out.println("Application Lab: " + applicationLab);
                System.out.println("Local Credits: " + localCredits);
                System.out.println("ECTS: " + ECTS);
                System.out.println("Prerequisites: " + prerequisites);
                System.out.println("Course Language: " + courseLanguage);
                System.out.println("Course Type: " + courseType);
                System.out.println("Course Level: " + courseLevel);
                System.out.println("Mode of Delivery: " + modeOfDelivery);
                System.out.println("Teaching Methods: " + teachingMethods);
                System.out.println("Course Coordinator: " + courseCoordinator);
                System.out.println("Course Lecturers: " + courseLecturers);
                System.out.println("Assistants: " + assistants);
                System.out.println("Course Objectives: " + courseObjectives);
                System.out.println("Learning Outcomes: " + learningOutcomes);
                System.out.println("Course Description: " + courseDescription);
                System.out.println("Course Category: " + courseCategory);
                System.out.println("Course Notes: " + courseNotes);
                System.out.println("Suggested Materials: " + suggestedMaterials);

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

