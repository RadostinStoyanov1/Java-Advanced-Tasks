package P06MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (matrix[row][col] != 0) {
                    System.out.print(matrix[row][col] + " ");
                    matrix[row][col] = 0;
                    boolean isDiagonalToPrint = diagonalPositionValid(matrix, row, col);
                    if (isDiagonalToPrint) {
                        int counter = 1;
                        while (isDiagonalToPrint) {
                            System.out.print(matrix[row - counter][col + counter] + " ");
                            matrix[row - counter][col + counter] = 0;
                            counter++;
                            isDiagonalToPrint = diagonalPositionValid(matrix, row - counter + 1, col + counter - 1);
                        }
                    }
                    System.out.println();
                }
            }
        }


    }

    private static boolean diagonalPositionValid(int[][] matrix, int row, int col) {
        return row - 1 >= 0 && col + 1 < matrix[row - 1].length;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}
