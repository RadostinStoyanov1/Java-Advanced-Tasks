package P04StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArg = rawCommand.split("\\s+");

            switch (commandArg[0]) {
                case "1":
                    commands.push(rawCommand);
                    text.append(commandArg[1]);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int numChars = Integer.parseInt(commandArg[1]);
                    String removedText = text.substring(text.length() - numChars, text.length());
                    removedElements.push(removedText);
                    text.replace(text.length() - numChars, text.length(), "");
                    break;
                case "3":
                    int index = Integer.parseInt(commandArg[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    if (lastCommand.startsWith("1")) {
                        int numElementsToDelete = lastCommand.split("\\s+")[1].length();
                        text.replace(text.length() - numElementsToDelete, text.length(), "");
                    } else {
                        text.append(removedElements.pop());
                    }
                    break;
            }
        }

    }
}
