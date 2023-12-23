import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonClass {
    public void json(Syllabus syllabus) {

        JsonToHtmlClass jsonToHtmlClass = new JsonToHtmlClass();

        String jsonFilePath = "SyllabusesJsonFile.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            JsonNode jsonData = objectMapper.createObjectNode();

            JsonNode newCourse = objectMapper.createObjectNode()
                    .put("courseName", syllabus.getGeneralInformation().getCourseName())
                    .put("courseCode", syllabus.getGeneralInformation().getCourseCode())
                    .put("semester", syllabus.getGeneralInformation().getSemester())
                    .put("theory", syllabus.getGeneralInformation().getTheoryHour())
                    .put("applicationLab", syllabus.getGeneralInformation().getLabHour())
                    .put("localCredits", syllabus.getGeneralInformation().getLocalCredit())
                    .put("ECTS", syllabus.getGeneralInformation().getEcts())
                    .put("prerequisites", syllabus.getGeneralInformation().getPrerequisites())
                    .put("courseLanguage", syllabus.getGeneralInformation().getCourseLanguage())
                    .put("courseType", syllabus.getGeneralInformation().getCourseType())
                    .put("courseLevel", syllabus.getGeneralInformation().getCourseLevel())
                    .put("modeOfDelivery", syllabus.getGeneralInformation().getModeOfDelivery())
                    .put("teachingMethods", syllabus.getGeneralInformation().getTeachingMethods())
                    .put("courseCoordinator", syllabus.getGeneralInformation().getCourseCoordinator())
                    .put("courseLecturers", syllabus.getGeneralInformation().getCourseLecturer())
                    .put("assistants", syllabus.getGeneralInformation().getCourseAssistant())
                    .put("courseObjectives", syllabus.getGeneralInformation().getCourseObjective())
                    .put("learningOutcomes", syllabus.getGeneralInformation().getLearningOutcomes())
                    .put("courseDescription", syllabus.getGeneralInformation().getCourseDescription())
                    .put("courseCategory", syllabus.getGeneralInformation().getCourseCategory())
                    .put("courseNotes", syllabus.getWeeklySubjects().getCourseNotes())
                    .put("suggestedMaterials", syllabus.getWeeklySubjects().getSuggestedReadings());;


            for (int week = 1; week <= 16; week++) {
                ((ObjectNode) newCourse).put("week" + week + "_subjects", "Subjects for Week " + week);
                ((ObjectNode) newCourse).put("week" + week + "_materials", "Materials for Week " + week);
            }

            for (int row = 1; row <= 15; row++) {
                ((ObjectNode) newCourse).put("semesterActivity" + row, "Activity " + row);
                ((ObjectNode) newCourse).put("number" + row, "Number " + row);
                ((ObjectNode) newCourse).put("weighting" + row, "Weighting " + row);
                ((ObjectNode) newCourse).put("LO1_" + row, "LO1 " + row);
                ((ObjectNode) newCourse).put("LO2_" + row, "LO2 " + row);
                ((ObjectNode) newCourse).put("LO3_" + row, "LO3 " + row);
                ((ObjectNode) newCourse).put("LO4_" + row, "LO4 " + row);
            }

            for (int row = 1; row <= 14; row++) {
                ((ObjectNode) newCourse).put("semesterActivity" + row, "Activity " + row);
                ((ObjectNode) newCourse).put("number" + row, "Number " + row);
                ((ObjectNode) newCourse).put("duration" + row, "Duration " + row);
                ((ObjectNode) newCourse).put("workload" + row, "Workload " + row);
            }

            for (int row = 1; row <= 13; row++) {
                ((ObjectNode) newCourse).put("activityNumber" + row, row);
                ((ObjectNode) newCourse).put("programCompetencies" + row, "Competency/Outcome " + row);
                ((ObjectNode) newCourse).put("contributionLevel" + row, "Contribution Level " + row);
            }


            List<JsonNode> syllabuses = new ArrayList<>();
            syllabuses.add(newCourse);


            ((ObjectNode) jsonData).set("syllabuses", objectMapper.valueToTree(syllabuses));


            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File(jsonFilePath), jsonData);

            System.out.println("New course added to JSON: " + newCourse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonToHtmlClass.jsonToHTML();
    }

}
