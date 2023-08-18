package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> tokensStack = new ArrayDeque<>();

        Collections.addAll(tokensStack, tokens);

        while (tokensStack.size() > 1) {
            int firstNum = Integer.parseInt(tokensStack.pop());
            String sign = tokensStack.pop();
            int secondNum = Integer.parseInt(tokensStack.pop());

            switch (sign) {
                case "-":
                    tokensStack.push(String.valueOf(firstNum - secondNum));
                    break;
                case "+":
                    tokensStack.push(String.valueOf(firstNum + secondNum));
                    break;
            }

        }

        System.out.println(tokensStack.pop());

    }
}
