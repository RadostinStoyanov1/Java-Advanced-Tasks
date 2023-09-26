package P11FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");
        int lowLimit = Integer.parseInt(arr[0]);
        int upperLimit = Integer.parseInt(arr[1]);

        String command = scanner.nextLine();

        Predicate<Integer> tester = createTester(command);

        for (int i = lowLimit; i <= upperLimit; i++) {
            printRightNum(i, tester);
        }

    }

    private static void printRightNum(int i, Predicate<Integer> tester) {
        if (tester.test(i)) {
            System.out.print(i + " ");
        }
    }

    private static Predicate<Integer> createTester(String command) {
        Predicate<Integer> tester = null;
        switch (command) {
            case "even":
                tester = i -> i % 2 == 0;
                break;
            case "odd":
                tester = i -> i % 2 != 0;
                break;
        }
        return tester;
    }
}
