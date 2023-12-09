public class Assessment {
    private String semesterActivities;
    private int number, weighting, lo1, lo2, lo3, lo4, lo5, lo6, lo7;

    public Assessment(String semesterActivities, int number, int weighting, int lo1, int lo2, int lo3, int lo4, int lo5, int lo6, int lo7) {
        this.semesterActivities = semesterActivities;
        this.number = number;
        this.weighting = weighting;
        this.lo1 = lo1;
        this.lo2 = lo2;
        this.lo3 = lo3;
        this.lo4 = lo4;
        this.lo5 = lo5;
        this.lo6 = lo6;
        this.lo7 = lo7;
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

    public int getWeighting() {
        return weighting;
    }

    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }

    public int getLo1() {
        return lo1;
    }

    public void setLo1(int lo1) {
        this.lo1 = lo1;
    }

    public int getLo2() {
        return lo2;
    }

    public void setLo2(int lo2) {
        this.lo2 = lo2;
    }

    public int getLo3() {
        return lo3;
    }

    public void setLo3(int lo3) {
        this.lo3 = lo3;
    }

    public int getLo4() {
        return lo4;
    }

    public void setLo4(int lo4) {
        this.lo4 = lo4;
    }

    public int getLo5() {
        return lo5;
    }

    public void setLo5(int lo5) {
        this.lo5 = lo5;
    }

    public int getLo6() {
        return lo6;
    }

    public void setLo6(int lo6) {
        this.lo6 = lo6;
    }

    public int getLo7() {
        return lo7;
    }

    public void setLo7(int lo7) {
        this.lo7 = lo7;
    }
}
