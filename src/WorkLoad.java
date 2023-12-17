public class WorkLoad {
    private String semesterActivities;
    private int number, duration, workload;

    public WorkLoad(String semesterActivities, int number, int duration, int workload) {
        this.semesterActivities = semesterActivities;
        this.number = number;
        this.duration = duration;
        this.workload = workload;
    }

    public WorkLoad() {

    }

    public String getSemesterActivities() {
        return semesterActivities;
    }

    public void setSemesterActivities(String semesterActivities) {
        this.semesterActivities = semesterActivities;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
}
