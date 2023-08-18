package P04StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        StringBuilder output = new StringBuilder();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        int currentPrecedence = 0;
        int previousPrecedence = -1;
        char previousOperator = ' ';

        for (String s : input) {
            char currentChar = s.charAt(0);
            
            if (Character.isLetterOrDigit(currentChar)) {
                output.append(s);
                output.append(" ");
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '(') {
                switch (currentChar) { //here we obtain the currentChar precedence
                    case '-':
                    case '+':
                        previousPrecedence = currentPrecedence;
                        currentPrecedence = 2;
                        break;
                    case '*':
                    case '/':
                        previousPrecedence = currentPrecedence;
                        currentPrecedence = 3;
                        break;
                    case '(':
                        previousPrecedence = -1;
                        currentPrecedence = 0;
                        previousOperator = currentChar;
                        break;
                }
                if (currentPrecedence <= previousPrecedence && (previousPrecedence != -1 && currentPrecedence != 0)) {
                    output.append(operatorsStack.pop());
                    output.append(" ");
                }
                operatorsStack.push("" + currentChar);

                previousOperator = currentChar;
            } else if (currentChar == ')') {
                String currentSymbol = "";
                while (!currentSymbol.equals("(")){
                    currentSymbol = operatorsStack.pop();
                    if (!currentSymbol.equals("(")) {
                        output.append(currentSymbol);
                        output.append(" ");
                    }
                }
                if (!operatorsStack.isEmpty()) {
                    String checkElement = operatorsStack.peek();
                    switch (checkElement) {
                        case "-":
                        case "+":
                            currentPrecedence = 2;
                            break;
                        case "*":
                        case "/":
                            currentPrecedence = 3;
                            break;
                    }
                } else {
                    currentPrecedence = 0;
                    previousPrecedence = -1;
                }
            }
        }

        if (!operatorsStack.isEmpty()) {
            while (!operatorsStack.isEmpty()) {
                String movedElement = operatorsStack.pop();
                if (!movedElement.equals("(")) {
                    output.append(movedElement);
                    output.append(" ");
                }
            }
        }

        System.out.println(output);

    }
}
