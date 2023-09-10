package P05MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = ", ";

        int[] sizes = readDimensions(scanner, pattern);
        int rows = sizes[0];
        int cols = sizes[1];

        int[][] matrix = readMatrix(scanner, rows, cols, pattern);
        
        int sum = 0;

        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readDimensions(scanner, pattern);
        }
        return matrix;
    }

    private static int[] readDimensions(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
