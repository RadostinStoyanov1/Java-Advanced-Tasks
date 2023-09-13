package P07SetsAndMapsAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsTreeMap = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String currentName = tokens[0];
            double currentMark = Double.parseDouble(tokens[1]);

            if (!studentsTreeMap.containsKey(currentName)) {
                studentsTreeMap.put(currentName, new ArrayList<>());
            }

            studentsTreeMap.get(currentName).add(currentMark);
        }

        for (Map.Entry<String, List<Double>> entry : studentsTreeMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double avg = 0.0;
            for (Double mark : entry.getValue()) {
                avg += mark;
                System.out.printf("%.2f ", mark);
            }
            avg = avg / entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);
        }

    }
}
