public class WorkLoad {
    private String semesterActivities;
    private String number, duration, workload;

    public WorkLoad(String semesterActivities, String number, String duration, String workload) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }
}
