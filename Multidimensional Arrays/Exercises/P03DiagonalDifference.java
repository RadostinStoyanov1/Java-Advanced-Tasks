package P06MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        readMatrix(scanner, matrix);

        int sumFirstDiagonal = sumLeftDiagonal(matrix);
        int sumSecondDiagonal = sumRightDiagonal(matrix);

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));

    }

    private static int sumRightDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    private static int sumLeftDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
