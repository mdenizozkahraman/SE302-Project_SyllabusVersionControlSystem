import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToHtmlClass {
    public static void main(String[] args) {
        String jsonFilePath = "jsonTest.json";
        String htmlOutputFilePath = "htmlFiles/output.html";

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
            System.out.println("HTML çıktısı " + filePath + " dosyasına başarıyla yazıldı.");
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

        htmlBuilder.append("<h1>Course List</h1>\n");
        htmlBuilder.append("<table border=\"1\">\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Course Code</th>\n");
        htmlBuilder.append("<th>Course Name</th>\n");
        htmlBuilder.append("<th>Instructor</th>\n");
        htmlBuilder.append("<th>Credits</th>\n");
        htmlBuilder.append("</tr>\n");

        for (JsonNode course : jsonData.get("courses")) {
            htmlBuilder.append("<tr>\n");
            htmlBuilder.append("<td>").append(course.get("courseCode").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("courseName").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("instructor").asText()).append("</td>\n");
            htmlBuilder.append("<td>").append(course.get("credits").asText()).append("</td>\n");
            htmlBuilder.append("</tr>\n");
        }

        htmlBuilder.append("</table>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }



}
