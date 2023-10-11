package P18Generics_Exercise.P05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxes.add(box);
        }

        Box<String> compareBox = new Box<>(scanner.nextLine());
        int countedElements = countGreaterResults(boxes, compareBox);
        System.out.println(countedElements);
    }

    private static <T extends Comparable<T>> int countGreaterResults(List<T> data, T compareElement) {
        int counter = 0;
        for (T element : data) {
            int res = element.compareTo(compareElement);
            if (res > 0) {
                counter++;
            }
        }
        return counter;
    }

}
