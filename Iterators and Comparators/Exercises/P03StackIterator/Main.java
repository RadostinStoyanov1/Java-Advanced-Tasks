package P20IteratorsAndComparators_Exercise.P03StackIterator;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StackIterator stack = new StackIterator();

        while (!line.equals("END")) {
            String[] tokens = line.split("[\\s,]+");
            switch (tokens[0]) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        stack.forEach(System.out::println);
    }
}
