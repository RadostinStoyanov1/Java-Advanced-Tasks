package ExamPreparationTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> timesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> timesQueue.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> tasksStack.push(Integer.parseInt(e)));

        int darthVaderDuckyCount = 0;
        int thorDuckyCount = 0;
        int bigBlueRubberDuckyCount = 0;
        int smallYellowRubberDucky = 0;

        while (!timesQueue.isEmpty() && !tasksStack.isEmpty()) {
            int currentTime = timesQueue.poll();
            int currentTask = tasksStack.pop();
            int result = currentTask * currentTime;

            if (result >= 0 && result <= 60) {
                darthVaderDuckyCount++;
            } else if (result > 60 && result <= 120) {
                thorDuckyCount++;
            } else if (result > 120 && result <= 180) {
                bigBlueRubberDuckyCount++;
            } else if (result > 180 && result <= 240) {
                smallYellowRubberDucky++;
            } else if (result > 240) {
                currentTask -= 2;
                tasksStack.push(currentTask);
                timesQueue.offer(currentTime);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d\n", darthVaderDuckyCount);
        System.out.printf("Thor Ducky: %d\n", thorDuckyCount);
        System.out.printf("Big Blue Rubber Ducky: %d\n", bigBlueRubberDuckyCount);
        System.out.printf("Small Yellow Rubber Ducky: %d\n", smallYellowRubberDucky);
    }
}
