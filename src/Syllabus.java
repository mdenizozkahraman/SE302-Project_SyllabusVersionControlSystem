public class Syllabus {
   private final int id;
   private Assessment assessment;
   private CourseOutcome courseOutcome;
   private GeneralInformation generalInformation;
   private WeeklySubjects weeklySubjects;
   private WorkLoad workLoad;


    public Syllabus(int id, String courseName, String courseCode, String semester, int theoryHour, int labHour, int localCredit, int ects, Assessment assessment, CourseOutcome courseOutcome, GeneralInformation generalInformation, WeeklySubjects weeklySubjects, WorkLoad workLoad) {
        this.id = id;
        this.assessment = assessment;
        this.courseOutcome = courseOutcome;
        this.generalInformation = generalInformation;
        this.weeklySubjects = weeklySubjects;
        this.workLoad = workLoad;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public CourseOutcome getCourseOutcome() {
        return courseOutcome;
    }

    public void setCourseOutcome(CourseOutcome courseOutcome) {
        this.courseOutcome = courseOutcome;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public WeeklySubjects getWeeklySubjects() {
        return weeklySubjects;
    }

    public void setWeeklySubjects(WeeklySubjects weeklySubjects) {
        this.weeklySubjects = weeklySubjects;
    }

    public WorkLoad getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(WorkLoad workLoad) {
        this.workLoad = workLoad;
    }

    public int getId() {
        return id;
    }

}
