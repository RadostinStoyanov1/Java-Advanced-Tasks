package P20IteratorsAndComparators_Exercise.P01ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ListyIterator<String> listyIterator = new ListyIterator<>();

        while (!line.equals("END")) {
            String command = line.split("\\s+")[0];

            switch (command) {
                case "Create":
                    String[] tokens = line.split("\\s+");
                    if (tokens.length > 1) {
                        String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
                        listyIterator = new ListyIterator<>(elements);
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
