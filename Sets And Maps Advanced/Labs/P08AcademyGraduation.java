package P07SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            List<Double> marks = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            if (students.containsKey(name)) {
                for (int j = 0; j < marks.size(); j++) {
                    students.get(name).add(marks.get(j));
                }
            } else {
                students.put(name, marks);
            }
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            //double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble(); //doesn't work properly

            double sum = getSum(entry.getValue());
            int size = entry.getValue().size();
            double avg = sum / size;
            System.out.println(String.format("%s is graduated with %s", entry.getKey(), avg));
        }
    }

    private static double getSum(List<Double> value) {
        double sum = 0.0;
        for (int i = 0; i < value.size(); i++) {
            sum += value.get(i);
        }
        return sum;

    }
}
