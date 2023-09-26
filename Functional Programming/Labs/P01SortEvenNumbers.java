package P11FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        //System.out.println(numbers.stream().map(num -> num + "").collect(Collectors.joining(", ")));

        printListWithCommas(numbers);
        Collections.sort(numbers);
        printListWithCommas(numbers);

    }

    private static void printListWithCommas(List<Integer> numbers) {
        List<String> numbersAsText = new ArrayList<>();
        for (Integer number : numbers) {
            numbersAsText.add(String.valueOf(number));
        }
        System.out.println(String.join(", ", numbersAsText));
    }
}
