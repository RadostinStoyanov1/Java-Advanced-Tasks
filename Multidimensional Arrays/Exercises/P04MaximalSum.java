package P06MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];

        for (int row = 0; row <= matrix.length - 3 ; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                int sum = getSum(matrix, row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    fillSubMatrix(matrix, row, col, subMatrix);
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(subMatrix);

    }

    private static void fillSubMatrix(int[][] matrix, int row, int col, int[][] subMatrix) {
        int rowCounter = 0;
        for (int i = row; i < row + 3; i++) {
            int[] arr = new int[3];
            int colCounter = 0;
            for (int j = col; j < col + 3; j++) {
                arr[colCounter] = matrix[i][j];
                colCounter++;
            }
            subMatrix[rowCounter] = arr;
            rowCounter++;
        }
    }

    private static int getSum(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            matrix[row] = arr;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
