package P05MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

        for (int row = 0; row < size; row++) {
            System.out.print(matrix[row][row] + " ");
        }

        System.out.println();

        for (int row = size - 1; row >= 0; row--) {
            System.out.print(matrix[row][size - 1 - row] + " ");
        }

    }
}
