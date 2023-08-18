package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String command = scanner.nextLine();
        String currentUrl = "";

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!historyStack.isEmpty()) {
                    currentUrl = historyStack.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    historyStack.push(currentUrl);
                }
                currentUrl = command;
            }

            System.out.println(currentUrl);

            command = scanner.nextLine();
        }

    }
}
