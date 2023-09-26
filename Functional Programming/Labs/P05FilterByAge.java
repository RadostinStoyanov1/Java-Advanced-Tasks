package P11FunctionalProgramming;

import javax.sound.midi.Soundbank;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.*;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> persons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(", ")[0];
            int age = Integer.parseInt(input.split(", ")[1]);
            persons.put(name, age);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(persons, tester, printer);
    }

    private static void printFilteredStudent(Map<String, Integer> persons, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : persons.entrySet()) {
            if (tester.test(persons.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.println(person.getKey());
                break;
            case "age":
                printer = person -> System.out.println(person.getValue());
                break;
        }
        return printer;
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = x -> x <= age;
                break;
            case "older":
                tester = x -> x >= age;
                break;
        }
        return tester;
    }
}
