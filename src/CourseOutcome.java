public class CourseOutcome {
    private int number;
    private String programCompetencies;
    private int contributionLevel[];

    public CourseOutcome(int number, String programCompetencies, int[] contributionLevel) {
        this.number = number;
        this.programCompetencies = programCompetencies;
        this.contributionLevel = contributionLevel;
    }

    public CourseOutcome() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProgramCompetencies() {
        return programCompetencies;
    }

    public void setProgramCompetencies(String programCompetencies) {
        this.programCompetencies = programCompetencies;
    }

    public int[] getContributionLevel() {
        return contributionLevel;
    }

    public void setContributionLevel(int[] contributionLevel) {
        this.contributionLevel = contributionLevel;
    }
}
