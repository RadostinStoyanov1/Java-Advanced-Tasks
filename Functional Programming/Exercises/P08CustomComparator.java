package P12FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1; //не разменяме числата
            }
            if (first % 2 != 0 && second % 2 == 0) {
                return 1; //разменяме числата
            }
            return first.compareTo(second); //сравняваме от по-малко към по-голямо ако и двете числа са четни или и двете са нечетни
        };

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
