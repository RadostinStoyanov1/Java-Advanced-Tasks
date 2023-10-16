package P20IteratorsAndComparators_Exercise.P04Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] elements = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(elements);

        Iterator<Integer> iterator = lake.iterator();
        boolean isNotLastElement;
        while (iterator.hasNext()){
            Integer element = iterator.next();
            isNotLastElement = iterator.hasNext();
            if (isNotLastElement) {
                System.out.print(element + ", ");
            } else {
                System.out.print(element);
            }

        }
    }
}
