package ExamPreparationTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> armorQueue = new ArrayDeque<>();
        ArrayDeque<Integer> strikesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).forEach(armorQueue::offer);
        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).forEach(strikesStack::push);
        int monstersKilled = 0;

        while (!armorQueue.isEmpty() && !strikesStack.isEmpty()) {
            int armor = armorQueue.poll();
            int strike = strikesStack.pop();

            if (strike >= armor) {
                monstersKilled++;
                if (strike - armor > 0) {
                    if (strikesStack.isEmpty()) {
                        strikesStack.push(strike - armor);
                    } else {
                        strikesStack.push(strikesStack.pop() + (strike - armor));
                    }
                }
            } else {
                armorQueue.offer(armor - strike);
            }
        }
        if (armorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (strikesStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", monstersKilled);
    }
}
