package P11FunctionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P01SortEvenNumbersWithoutLambda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading Input Data
        String input = scanner.nextLine();
        String[] splitInput = input.split(", ");
        List<Integer> numbers = new ArrayList<>();
        for (String text : splitInput) {
            int num = Integer.parseInt(text);
            if (num %2 == 0) {
                numbers.add(num);
            }
        }

        //Printing even numbers
        printNumbers(numbers);

        //Sorting the List in ascending order
        Collections.sort(numbers);

        //Printing even numbers
        System.out.println();
        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers.toString().replace("[", "").replace("]", ""));
    }
}
