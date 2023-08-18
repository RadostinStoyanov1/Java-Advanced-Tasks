package P03StacksAndQueues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        PriorityQueue<String> kidsQueue = new PriorityQueue<>();

        for (int i = 0; i < namesArr.length; i++) {
            kidsQueue.offer(namesArr[i]);
        }

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String movedKid = kidsQueue.poll();
                kidsQueue.offer(movedKid);
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + kidsQueue.peek());
            } else {
                System.out.println("Removed " + kidsQueue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + kidsQueue.poll());

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
