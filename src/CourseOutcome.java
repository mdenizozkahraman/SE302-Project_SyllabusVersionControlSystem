public class CourseOutcome {
    private String number;
    private String programCompetencies;
    private String contributionLevel;

    public CourseOutcome(String number, String programCompetencies, String contributionLevel) {
        this.number = number;
        this.programCompetencies = programCompetencies;
        this.contributionLevel = contributionLevel;
    }

    public CourseOutcome() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProgramCompetencies() {
        return programCompetencies;
    }

    public void setProgramCompetencies(String programCompetencies) {
        this.programCompetencies = programCompetencies;
    }

    public String getContributionLevel() {
        return contributionLevel;
    }

    public void setContributionLevel(String contributionLevel) {
        this.contributionLevel = contributionLevel;
    }
}
