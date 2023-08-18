package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();
        ArrayDeque<String> filesQueue = new ArrayDeque<>();

        while (!fileName.equals("print")) {
            if (fileName.equals("cancel")) {
                if (!filesQueue.isEmpty()) {
                    System.out.println("Canceled " + filesQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                filesQueue.offer(fileName);
            }

            fileName = scanner.nextLine();
        }

        while (!filesQueue.isEmpty()) {
            System.out.println(filesQueue.poll());
        }

    }
}
