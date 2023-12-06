public class Syllabus {
   private final int id;
   private String courseName, courseCode, semester;
   private int theoryHour, labHour, localCredit, ects;


    public Syllabus(int id, String courseName, String courseCode, String semester, int theoryHour, int labHour, int localCredit, int ects) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.semester = semester;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.localCredit = localCredit;
        this.ects = ects;
    }

    public int getId() {
        return id;
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
}
