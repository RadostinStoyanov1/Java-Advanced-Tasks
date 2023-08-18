package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();
        ArrayDeque<String> backHistoryQueue = new ArrayDeque<>();

        String command = scanner.nextLine();
        String currentUrl = "";

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!historyStack.isEmpty()) {
                    backHistoryQueue.push(currentUrl);
                    currentUrl = historyStack.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("forward")) {
                if (!backHistoryQueue.isEmpty()) {
                    currentUrl = backHistoryQueue.pop();
                } else {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    historyStack.push(currentUrl);
                    backHistoryQueue.clear();
                }
                currentUrl = command;
            }

            System.out.println(currentUrl);

            command = scanner.nextLine();
        }

    }
}
