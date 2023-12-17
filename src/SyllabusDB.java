import java.sql.*;

public class SyllabusDB {

    private static void clearSyllabusTable(Connection con) throws SQLException {
        String clearTableSQL = "DELETE FROM syllabus_table";
        try (PreparedStatement preparedStatement = con.prepareStatement(clearTableSQL)){
            preparedStatement.executeUpdate();
        }
    }

    public static void connect() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:SyllabusDB.db";

            con = DriverManager.getConnection(url);

            try {
                System.out.println("Connection to SQLite has been established");

                // Creating syllabus_table if it doesn't already exist
                createSyllabusTable(con);
                clearSyllabusTable(con);


                Syllabus syllabus = new Syllabus(
                        1,"Fundamental Topics in Programming", "CE216", "Spring",
                        2, 2, 3, 6,
                        new Assessment(), new CourseOutcome(),
                        new GeneralInformation(), new WeeklySubjects(), new WorkLoad()
                );

                // new syllabus
                addSyllabus(con, syllabus);

                syllabus.setEcts(6);
                editSyllabus(con, syllabus);

                deleteSyllabus(con, syllabus.getId());

                // Retrieve and print data only once after all operations are completed
                retrieveData(con, "syllabus_table");

            } catch (SQLException e) {
                System.out.println("Error during database operations: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error while closing connection: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    private static void createSyllabusTable(Connection con) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS syllabus_table (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "courseName VARCHAR(255), " +
                "courseCode VARCHAR(255), " +
                "semester VARCHAR(255), " +
                "theoryHour INTEGER, " +
                "labHour INTEGER, " +
                "localCredit INTEGER, " +
                "ECTS INTEGER, " +
                "assessment BLOB, " +
                "courseOutcome BLOB, " +
                "generalInformation BLOB, " +
                "weeklySubjects BLOB, " +
                "workLoad BLOB);";

        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(createTableQuery);
        }
    }

    private static void addSyllabus(Connection con, Syllabus syllabus) throws SQLException {
        String addSyllabusSQL = "INSERT INTO syllabus_table " +
                "(courseName, courseCode, semester, theoryHour, labHour, localCredit, ects, assessment, courseOutcome, generalInformation, weeklySubjects, workLoad) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(addSyllabusSQL)) {
            preparedStatement.setString(1, syllabus.getCourseName());
            preparedStatement.setString(2, syllabus.getCourseCode());
            preparedStatement.setString(3, syllabus.getSemester());
            preparedStatement.setInt(4, syllabus.getTheoryHour());
            preparedStatement.setInt(5, syllabus.getLabHour());
            preparedStatement.setInt(6, syllabus.getLocalCredit());
            preparedStatement.setInt(7, syllabus.getEcts());
            preparedStatement.setObject(8, syllabus.getAssessment());
            preparedStatement.setObject(9, syllabus.getCourseOutcome());
            preparedStatement.setObject(10, syllabus.getGeneralInformation());
            preparedStatement.setObject(11, syllabus.getWeeklySubjects());
            preparedStatement.setObject(12, syllabus.getWorkLoad());

            preparedStatement.executeUpdate();
        }
    }

    private static void retrieveData(Connection con, String tableName) throws SQLException {
        String retrieveDataSQL = "SELECT * FROM " + tableName;

        try (PreparedStatement preparedStatement = con.prepareStatement(retrieveDataSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("\nData from " + tableName + ":");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseName = resultSet.getString("courseName");
                String courseCode = resultSet.getString("courseCode");
                String semester = resultSet.getString("semester");
                int theoryHour = resultSet.getInt("theoryHour");
                int labHour = resultSet.getInt("labHour");
                int localCredit = resultSet.getInt("localCredit");
                int ects = resultSet.getInt("ects");

                System.out.println("ID: " + id);
                System.out.println("Course Name: " + courseName);
                System.out.println("Course Code: " + courseCode);
                System.out.println("Semester: " + semester);
                System.out.println("Theory Hour: " + theoryHour);
                System.out.println("Lab Hour: " + labHour);
                System.out.println("Local Credit: " + localCredit);
                System.out.println("ECTS: " + ects);
                System.out.println("----------------------");
            }
        }
    }

    private static void editSyllabus(Connection con, Syllabus syllabus) throws SQLException {
        String editSyllabusSQL = "UPDATE syllabus_table SET " +
                "courseName = ?, courseCode = ?, semester = ?, theoryHour = ?, labHour = ?, localCredit = ?, ects = ? " +
                "WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(editSyllabusSQL)) {
            preparedStatement.setString(1, syllabus.getCourseName());
            preparedStatement.setString(2, syllabus.getCourseCode());
            preparedStatement.setString(3, syllabus.getSemester());
            preparedStatement.setInt(4, syllabus.getTheoryHour());
            preparedStatement.setInt(5, syllabus.getLabHour());
            preparedStatement.setInt(6, syllabus.getLocalCredit());
            preparedStatement.setInt(7, syllabus.getEcts());
            preparedStatement.setInt(8, syllabus.getId());

            preparedStatement.executeUpdate();
        }
    }

    private static void deleteSyllabus(Connection con, int id) throws SQLException {
        String deleteSyllabusSQL = "DELETE FROM syllabus_table WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteSyllabusSQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        connect();
    }
}




