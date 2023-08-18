package P04StacksAndQueues_Exercise;

import java.util.*;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numInputs = input[0];
        int numPops = input[1];
        int elementPresent = input[2];
        ArrayDeque<Integer> numsStack = new ArrayDeque<>();
        int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numInputs; i++) {
            numsStack.push(inputNumbers[i]);
        }

        for (int i = 1; i <= numPops; i++) {
            numsStack.pop();
        }

        if (numsStack.isEmpty()) {
            System.out.println(0);
        } else if (numsStack.contains(elementPresent)) {
            System.out.println("true");
        } else {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            while (!numsStack.isEmpty()) {
                queue.offer(numsStack.pop());
            }
            System.out.println(Collections.min(numsStack));
        }
    }
}
