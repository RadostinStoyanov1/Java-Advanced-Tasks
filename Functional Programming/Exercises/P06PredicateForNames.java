package P12FunctionalProgramming_Exercise;

import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> checkNameLength = s -> s.length() <= maxLength;

        for (String name : names) {
            if (checkNameLength.test(name)) {
                System.out.println(name);
            }
        }
    }
}
