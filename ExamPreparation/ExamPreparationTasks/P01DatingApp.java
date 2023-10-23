package ExamPreparationTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femaleQueue::offer);


        int matches = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            if (maleStack.peek() <= 0) {
                maleStack.pop();
                continue;
            }
            if (femaleQueue.peek() <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (femaleQueue.peek() % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }
            if (maleStack.peek() % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (male == female) {
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(maleStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femaleQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
