import java.util.ArrayList;

public class GeneralInformation {
    private String courseName, courseCode, semester;
    private String theoryHour, labHour, localCredit, ects;


    private String prerequisites, teachingMethods, courseObjective, learningOutcomes, courseDescription;
    private String courseCategory, courseLanguage;
    private String courseCoordinator, courseLecturer, courseAssistant, courseLevel, courseType, modeOfDelivery;

    public GeneralInformation(String courseName, String courseCode, String semester, String theoryHour, String labHour, String localCredit, String ects, String prerequisites, String teachingMethods, String courseObjective, String learningOutcomes, String courseDescription, String courseCategory, String courseLanguage, String courseCoordinator, String courseLecturer, String courseAssistant, String courseLevel, String courseType, String modeOfDelivery) {
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
        this.courseLanguage = courseLanguage;
        this.courseCoordinator = courseCoordinator;
        this.courseLecturer = courseLecturer;
        this.courseAssistant = courseAssistant;
        this.courseLevel = courseLevel;
        this.courseType = courseType;
        this.modeOfDelivery = modeOfDelivery;
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

    public String getTheoryHour() {
        return theoryHour;
    }

    public void setTheoryHour(String theoryHour) {
        this.theoryHour = theoryHour;
    }

    public String getLabHour() {
        return labHour;
    }

    public void setLabHour(String labHour) {
        this.labHour = labHour;
    }

    public String getLocalCredit() {
        return localCredit;
    }

    public void setLocalCredit(String localCredit) {
        this.localCredit = localCredit;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
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

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public String getCourseCoordinator() {
        return courseCoordinator;
    }

    public void setCourseCoordinator(String courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public String getCourseAssistant() {
        return courseAssistant;
    }

    public void setCourseAssistant(String courseAssistant) {
        this.courseAssistant = courseAssistant;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getModeOfDelivery() {
        return modeOfDelivery;
    }

    public void setModeOfDelivery(String modeOfDelivery) {
        this.modeOfDelivery = modeOfDelivery;
    }
}
