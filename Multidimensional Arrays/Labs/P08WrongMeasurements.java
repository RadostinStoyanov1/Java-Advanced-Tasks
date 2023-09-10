package P05MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, n);
        int[][] outputMatrix = copyMatrix(matrix);

        int[] coordinates = readIntLine(scanner);
        int rowCoordinate = coordinates[0];
        int colCoordinate = coordinates[1];

        int wrongNum = matrix[rowCoordinate][colCoordinate];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNum) {
                    int sum = sumUp(matrix, row, col, wrongNum)
                            + sumDown(matrix, row, col, wrongNum)
                            + sumLeft(matrix, row, col, wrongNum)
                            + sumRight(matrix, row, col, wrongNum);
                    outputMatrix[row][col] = sum;
                }
            }
        }

        for (int[] row : outputMatrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }



    }

    private static int[][] copyMatrix(int[][] matrix) {
        int[][] outputMatrix = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            outputMatrix[row] = matrix[row].clone();
        }
        return outputMatrix;
    }

    private static int sumRight(int[][] matrix, int row, int col, int wrongNum) {
        int sum = 0;
        if ((col + 1) < matrix[row].length) {
            if (matrix[row][col + 1] != wrongNum) {
                sum = matrix[row][col + 1];
            }
        }
        return sum;
    }

    private static int sumLeft(int[][] matrix, int row, int col, int wrongNum) {
        int sum = 0;
        if((col - 1) >= 0) {
            if (matrix[row][col - 1] != wrongNum) {
                sum = matrix[row][col - 1];
            }
        }
        return sum;
    }

    private static int sumDown(int[][] matrix, int row, int col, int wrongNum) {
        int num = 0;
        if (row + 1 < matrix.length && col < matrix[row + 1].length) {
            if (matrix[row + 1][col] != wrongNum) {
                num = matrix[row + 1][col];
            }
        }
        return num;
    }

    private static int sumUp(int[][] matrix, int row, int col, int wrongNum) {
        int num = 0;
        if (row - 1 >= 0 && col < matrix[row - 1].length) {
            if (matrix[row - 1][col] != wrongNum) {
                num = matrix[row - 1][col];
            }
        }
        return num;
    }

    private static int[] readIntLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }


}
