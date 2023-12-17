import java.util.ArrayList;

public class GeneralInformation {
    private String courseName, courseCode, semester;
    private int theoryHour, labHour, localCredit, ects;


    private String prerequisites, teachingMethods, courseObjective, learningOutcomes, courseDescription;
    private String courseCategory[];
    private ArrayList<String> courseCoordinator, courseLecturer, courseAssistant;

    public GeneralInformation(String courseName, String courseCode, String semester, int theoryHour,
                              int labHour, int localCredit,int ects, String prerequisites,
                              String teachingMethods, String courseObjective,
                              String learningOutcomes, String courseDescription, String[] courseCategory,
                              ArrayList<String> courseCoordinator, ArrayList<String> courseLecturer,
                              ArrayList<String> courseAssistant)
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.semester = semester;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.localCredit = localCredit;
        this.ects = ects;
        this.prerequisites = prerequisites;
        this.teachingMethods = teachingMethods;
        this.courseObjective = courseObjective;
        this.learningOutcomes = learningOutcomes;
        this.courseDescription = courseDescription;
        this.courseCategory = courseCategory;
        this.courseCoordinator = courseCoordinator;
        this.courseLecturer = courseLecturer;
        this.courseAssistant = courseAssistant;
    }

    public GeneralInformation() {

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getTheoryHour() {
        return theoryHour;
    }

    public void setTheoryHour(int theoryHour) {
        this.theoryHour = theoryHour;
    }

    public int getLabHour() {
        return labHour;
    }

    public void setLabHour(int labHour) {
        this.labHour = labHour;
    }

    public int getLocalCredit() {
        return localCredit;
    }

    public void setLocalCredit(int localCredit) {
        this.localCredit = localCredit;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getTeachingMethods() {
        return teachingMethods;
    }

    public void setTeachingMethods(String teachingMethods) {
        this.teachingMethods = teachingMethods;
    }

    public String getCourseObjective() {
        return courseObjective;
    }

    public void setCourseObjective(String courseObjective) {
        this.courseObjective = courseObjective;
    }

    public String getLearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(String learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String[] getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String[] courseCategory) {
        this.courseCategory = courseCategory;
    }

    public ArrayList<String> getCourseCoordinator() {
        return courseCoordinator;
    }

    public void setCourseCoordinator(ArrayList<String> courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public ArrayList<String> getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(ArrayList<String> courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public ArrayList<String> getCourseAssistant() {
        return courseAssistant;
    }

    public void setCourseAssistant(ArrayList<String> courseAssistant) {
        this.courseAssistant = courseAssistant;
    }













}
