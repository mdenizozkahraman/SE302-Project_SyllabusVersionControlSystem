public class Assessment {
    private String semesterActivities;
    private String number, weighting, lo1, lo2, lo3, lo4;

    public Assessment(String semesterActivities, String number, String weighting, String lo1, String lo2, String lo3, String lo4) {
        this.semesterActivities = semesterActivities;
        this.number = number;
        this.weighting = weighting;
        this.lo1 = lo1;
        this.lo2 = lo2;
        this.lo3 = lo3;
        this.lo4 = lo4;
    }

    public Assessment() {
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

    public String getWeighting() {
        return weighting;
    }

    public void setWeighting(String weighting) {
        this.weighting = weighting;
    }

    public String getLo1() {
        return lo1;
    }

    public void setLo1(String lo1) {
        this.lo1 = lo1;
    }

    public String getLo2() {
        return lo2;
    }

    public void setLo2(String lo2) {
        this.lo2 = lo2;
    }

    public String getLo3() {
        return lo3;
    }

    public void setLo3(String lo3) {
        this.lo3 = lo3;
    }

    public String getLo4() {
        return lo4;
    }

    public void setLo4(String lo4) {
        this.lo4 = lo4;
    }
}
