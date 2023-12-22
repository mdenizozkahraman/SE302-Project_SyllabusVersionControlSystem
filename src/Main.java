import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();

        Assessment assessment = new Assessment();
        CourseOutcome courseOutcome = new CourseOutcome();
        GeneralInformation generalInformation = new GeneralInformation();
        WeeklySubjects weeklySubjects = new WeeklySubjects();
        WorkLoad workLoad = new WorkLoad();

        generalInformation.setCourseName(courseName);

        Syllabus syllabus = new Syllabus(0, assessment, courseOutcome, generalInformation, weeklySubjects, workLoad);

        System.out.println(syllabus.getGeneralInformation().getCourseName());


    }
}
