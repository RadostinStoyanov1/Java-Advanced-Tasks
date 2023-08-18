package P03StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");
        int n = scanner.nextInt();

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (int i = 0; i < namesArr.length; i++) {
            kidsQueue.offer(namesArr[i]);
        }

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String movedKid = kidsQueue.poll();
                kidsQueue.offer(movedKid);
            }
            System.out.println("Removed " + kidsQueue.poll());
        }

        System.out.println("Last is " + kidsQueue.poll());

    }
}
