package P11FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> words = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        words = words.stream().filter(isUpperCase).collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
