package P12FunctionalProgramming_Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> addSir = e -> System.out.println("Sir " + e);

        for (String name : names) {
            addSir.accept(name);
        }
    }
}
