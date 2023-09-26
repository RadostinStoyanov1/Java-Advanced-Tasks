package P11FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int countNumbers = numbers.size();

        Function<List<Integer>, Integer> sumElementsInList = list -> {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            return sum;
        };
        int sumNumbers = sumElementsInList.apply(numbers);

        System.out.println("Count = " + countNumbers);
        System.out.println("Sum = " + sumNumbers);
    }
}
