import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToHtmlClass {
    public static void main(String[] args) {
        String jsonFilePath = "SyllabusesJsonFile.json";
        String htmlOutputFilePath = "htmlFiles/exportedSyllabus.html";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File(jsonFilePath));

            String htmlContent = convertJsonToHtml(jsonData);

            writeHtmlToFile(htmlContent, htmlOutputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHtmlToFile(String htmlContent, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent);
            System.out.println("HTML output successfully written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String convertJsonToHtml(JsonNode jsonData) {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<<!DOCTYPE  html>\n");
        htmlBuilder.append("<html lang=\"en\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<meta charset=\"UTF-8\">\n");
        htmlBuilder.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        htmlBuilder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlBuilder.append("<title>Course List</title>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");

        htmlBuilder.append("<h1>IZMIR UNIVERSITY OF ECONOMICS COURSE OUTLINE FORM</h1>\n");
        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<h2>1.GENERAL INFORMATION</h2>\n");
        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Course Name</th>\n");
        htmlBuilder.append("<th>Code</th>\n");
        htmlBuilder.append("<th>Semester</th>\n");
        htmlBuilder.append("<th>Theory</th>\n");
        htmlBuilder.append("<th>Application/Lab</th>\n");
        htmlBuilder.append("<th>Local Credits</th>\n");
        htmlBuilder.append("<th>ECTS</th>\n");
        htmlBuilder.append("</tr>\n");

        for (JsonNode course : jsonData.get("syllabuses")) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append(course.get("courseName").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("courseCode").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("semester").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("theory").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("applicationLab").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("localCredits").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("ECTS").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }

        htmlBuilder.append("</table>\n");

        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<table border=\"1\">\n");

        for (JsonNode course : jsonData.get("syllabuses")) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Prerequisites").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("prerequisites").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Language").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseLanguage").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Type").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseType").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Level").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseLevel").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Mode of Delivery").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("modeOfDelivery").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Teaching Methods and Techniques").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("teachingMethods").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Coordinator").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseCoordinator").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Lecturer(s)").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseLecturers").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Assistant(s)").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("assistants").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Objectives").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseObjectives").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Learning Outcomes").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("learningOutcomes").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Description").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseDescription").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Category").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseCategory").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }
        htmlBuilder.append("</table>\n");

        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<h2>2.WEEKLY SUBJECTS AND REQUIRED MATERIALS</h2>\n");
        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Week</th>\n");
        htmlBuilder.append("<th>Subjects</th>\n");
        htmlBuilder.append("<th>Required Materials</th>\n");
        htmlBuilder.append("</tr>\n");

        for (int week = 1; week <= 16; week++) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append(week).append("</td>\n");

            if (week == 15) {
                htmlBuilder.append("<td>").append("Semester Review").append("</td>\n");
                htmlBuilder.append("<td>").append("").append("</td>\n");
            } else if (week == 16) {
                htmlBuilder.append("<td>").append("Final Exam").append("</td>\n");
                htmlBuilder.append("<td>").append("").append("</td>\n");
            } else {
                htmlBuilder.append("<td>").append("").append("</td>\n");
                htmlBuilder.append("<td>").append("").append("</td>\n");
            }

            htmlBuilder.append("</tr>\n");
        }
        htmlBuilder.append("</table>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<table border=\"1\">\n");
        for (JsonNode course : jsonData.get("syllabuses")) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Course Notes/Textbooks").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("courseNotes").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");

            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<th>").append("Suggested Reading/Materials").append("</th>\n");
            htmlBuilder.append("<td>").append(course.get("suggestedMaterials").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }

        htmlBuilder.append("</table>\n");

        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<h2>3.ASSESSMENT</h2>\n");
        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Semester Activities</th>\n");
        htmlBuilder.append("<th>Number</th>\n");
        htmlBuilder.append("<th>Weighting</th>\n");
        htmlBuilder.append("<th>LO1</th>\n");
        htmlBuilder.append("<th>LO2</th>\n");
        htmlBuilder.append("<th>LO3</th>\n");
        htmlBuilder.append("<th>LO4</th>\n");
        htmlBuilder.append("</tr>\n");

        for (int row = 1; row <= 13; row++) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append("Activity " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Number " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Weighting " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("LO1 " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("LO2 " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("LO3 " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("LO4 " + row).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }

        htmlBuilder.append("</table>\n");
        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<h2>4.ECTS / WORKLOAD TABLE</h2>\n");
        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Semester Activities</th>\n");
        htmlBuilder.append("<th>Number</th>\n");
        htmlBuilder.append("<th>Duration</th>\n");
        htmlBuilder.append("<th>Workload</th>\n");
        htmlBuilder.append("</tr>\n");

        for (int row = 1; row <= 14; row++) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append("Activity " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Number " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Duration " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Workload " + row).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }

        htmlBuilder.append("</table>\n");
        htmlBuilder.append("<br>\n");
        htmlBuilder.append("<br>\n");

        htmlBuilder.append("<h2>5.COURSE/PROGRAM OUTCOME MATRIX\n</h2>\n");

        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>#</th>\n");
        htmlBuilder.append("<th>Program Competencies/Outcomes</th>\n");
        htmlBuilder.append("<th>Contribution Level</th>\n");
        htmlBuilder.append("</tr>\n");

        for (int row = 1; row <= 13; row++) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append(row).append("</td>\n");
            htmlBuilder.append("<td>").append("Competency/Outcome " + row).append("</td>\n");
            htmlBuilder.append("<td>").append("Contribution Level " + row).append("</td>\n");
            htmlBuilder.append("</tr>\n");

        }

        htmlBuilder.append("</table>\n");





        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }



}
