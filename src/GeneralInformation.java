import java.util.ArrayList;

public class GeneralInformation {
    private String prerequisites, teachingMethods, courseObjective, learningOutcomes, courseDescription;
    private String courseCategory[];
    private ArrayList<String> courseCoordinator, courseLecturer, courseAssistant;

    public GeneralInformation(String prerequisites, String teachingMethods, String courseObjective,
                              String learningOutcomes, String courseDescription, String[] courseCategory,
                              ArrayList<String> courseCoordinator, ArrayList<String> courseLecturer,
                              ArrayList<String> courseAssistant) {
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
