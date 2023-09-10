package P05MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Utils {

    Scanner scanner = new Scanner(System.in);
    public static void printMatrix(int[][] firstMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] arr = firstMatrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] readIntMatrix(Scanner scanner) {

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();

            matrix[row] = arr;
        }
        return matrix;
    }

    public static char[][] readCharMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

            matrix[row] = arr;
        }
        return matrix;
    }

}
