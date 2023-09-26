package P12FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        //Function<Integer[], Integer> findSmallestNum = arr -> Arrays.stream(arr).mapToInt(e -> e).min().getAsInt();
        //Function<Integer[], Integer> findSmallestNum = arr -> Arrays.stream(arr).sorted().toArray(Integer[]::new)[0];

        Function<Integer[], Integer> findSmallestNum = arr -> Collections.min(List.of(numbers));

        Integer smallestNumber = findSmallestNum.apply(numbers);
        System.out.println(smallestNumber);
    }
}
