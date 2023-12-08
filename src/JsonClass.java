import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonClass {
    public static void main(String[] args) {

        String jsonFilePath = "jsonTest.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonData = objectMapper.readTree(new File(jsonFilePath));

            JsonNode newCourse = objectMapper.createObjectNode()
                    .put("courseCode", "eeee")
                    .put("courseName", "aaaffefefea")
                    .put("instructor", "bbasdasdasdasb")
                    .put("credits", 1);

            List<JsonNode> syllabuses = new ArrayList<>();
            JsonNode coursesNode = jsonData.get("courses");
            if (coursesNode != null && coursesNode.isArray()) {
                for (JsonNode courseNode : coursesNode) {
                    syllabuses.add(courseNode);
                }
            }


            syllabuses.add(newCourse);


            ((ObjectNode) jsonData).replace("courses", objectMapper.valueToTree(syllabuses));


            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File(jsonFilePath), jsonData);

            System.out.println("New course added to JSON: " + newCourse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
