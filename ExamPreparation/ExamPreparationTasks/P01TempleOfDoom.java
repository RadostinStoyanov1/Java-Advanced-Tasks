package ExamPreparationTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(toolsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(substancesStack::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !challenges.isEmpty()) {
            int tool = toolsQueue.poll();
            int substance = substancesStack.pop();
            int result = tool * substance;

            if (challenges.contains(result)) {
                challenges.remove(Integer.valueOf(result));
            } else {
                toolsQueue.offer(tool + 1);
                if ((substance - 1) > 0) {
                    substancesStack.push(substance - 1);
                }
            }
        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.printf("Tools: %s\n", toolsQueue.toString()
                    .replaceAll("\\[", "")
                    .replaceAll("\\]", ""));
        }
        if (!substancesStack.isEmpty()) {
            System.out.printf("Substances: %s\n", substancesStack.toString()
                    .replaceAll("\\[", "")
                    .replaceAll("\\]", ""));
        }
        if (!challenges.isEmpty()) {
            System.out.printf("Challenges: %s\n", challenges.stream()
                    .map(num -> num + "")
                    .collect(Collectors.joining(", ")));
        }
    }
}
