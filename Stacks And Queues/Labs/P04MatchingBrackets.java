package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> openIndexStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(') {
                openIndexStack.push(i);
            } else if (currentChar == ')') {
                int lastOpenIndex = openIndexStack.pop();
                String currentExpression = expression.substring(lastOpenIndex, i + 1);
                System.out.println(currentExpression);
            }
        }
    }
}
