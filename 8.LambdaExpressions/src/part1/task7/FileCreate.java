package part1.task7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class FileCreate {

    public void getJSONFile(List<Employee> employeesList){
        Function<Employee, String> myFunctionJSON = employee -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\n");
            stringBuilder.append("\"firstname\":\"").append(employee.getFirstname()).append("\",\n");
            stringBuilder.append("\"lastname\":\"").append(employee.getLastname()).append("\",\n");
            stringBuilder.append("\"age\":\"").append(employee.getAge()).append("\",\n");
            stringBuilder.append("\"job\":\"").append(employee.getJob()).append("\",\n");
            stringBuilder.append("\"cityWorkExperience\":");
            stringBuilder.append("[");
            for (int i = 0; i < employee.getCityWorkExperience().length; i++) {
                stringBuilder.append("\"").append(employee.getCityWorkExperience()[i]).append("\"");
                if (i != employee.getCityWorkExperience().length - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            stringBuilder.append("\n}");

            return stringBuilder.toString();
        };

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("8.LambdaExpressions/src/part1/task7/JSON_data.json"))) {
            bufferedWriter.write("{\n");
            bufferedWriter.write("\"employees\"");
            bufferedWriter.write(":");
            bufferedWriter.write("[\n");

            for (int i = 0; i < employeesList.size(); i++) {
                bufferedWriter.write(myFunctionJSON.apply(employeesList.get(i)));
                if (i != employeesList.size() - 1) {
                    bufferedWriter.write(",\n");
                }
            }
            bufferedWriter.write("\n]");
            bufferedWriter.write("\n}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
