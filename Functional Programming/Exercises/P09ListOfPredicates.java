package P12FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> numsToCheck = i -> {
            for (int number : numbers) {
                if (i % number != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (numsToCheck.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
