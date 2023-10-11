package P18Generics_Exercise.P04GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            boxes.add(box);
        }

        String[] tokens = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(tokens[0]);
        int secondIndex = Integer.parseInt(tokens[1]);

        swap(boxes, firstIndex, secondIndex);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
        T element1 = data.get(firstIndex);
        T element2 = data.get(secondIndex);
        data.set(firstIndex, element2);
        data.set(secondIndex, element1);
    }
}
