package P12FunctionalProgramming_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        Consumer <String> print = System.out::println;

        /*for (String word : strings) {
            print.accept(word);
        }*/

        Arrays.stream(strings).forEach(print);

    }
}
