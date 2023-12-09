public class WeeklySubjects {
    private int week;
    private String subject, requiredMaterials, courseNotes, suggestedReadings;

    public WeeklySubjects(int week, String subject, String requiredMaterials, String courseNotes, String suggestedReadings) {
        this.week = week;
        this.subject = subject;
        this.requiredMaterials = requiredMaterials;
        this.courseNotes = courseNotes;
        this.suggestedReadings = suggestedReadings;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequiredMaterials() {
        return requiredMaterials;
    }

    public void setRequiredMaterials(String requiredMaterials) {
        this.requiredMaterials = requiredMaterials;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public String getSuggestedReadings() {
        return suggestedReadings;
    }

    public void setSuggestedReadings(String suggestedReadings) {
        this.suggestedReadings = suggestedReadings;
    }
}
