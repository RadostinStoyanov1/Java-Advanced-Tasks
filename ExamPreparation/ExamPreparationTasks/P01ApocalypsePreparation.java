package ExamPreparationTasks;

import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(textilesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(medicamentsStack::push);

        Map<String, Integer> heals = new TreeMap<>();
        heals.put("Patch", 0);
        heals.put("Bandage", 0);
        heals.put("MedKit", 0);

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int textile = textilesQueue.poll();
            int medicament = medicamentsStack.pop();
            int sum = textile + medicament;

            if (sum == 30) {
                heals.put("Patch", heals.get("Patch") + 1);
            } else if (sum == 40) {
                heals.put("Bandage", heals.get("Bandage") + 1);
            } else if (sum == 100) {
                heals.put("MedKit", heals.get("MedKit") + 1);
            } else if (sum > 100) {
                heals.put("MedKit", heals.get("MedKit") + 1);
                medicamentsStack.push(medicamentsStack.pop() + (sum - 100));
            } else {
                medicamentsStack.push(medicament + 10);
            }
        }

        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        Map<String, Integer> sortedDescendingMap = new LinkedHashMap<>();

        heals.entrySet().stream().sorted(Map.Entry
                .comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedDescendingMap.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : sortedDescendingMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(String.format("%s - %d", entry.getKey(), entry.getValue()));
            }
        }

        if (!medicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medicamentsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!textilesQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}
