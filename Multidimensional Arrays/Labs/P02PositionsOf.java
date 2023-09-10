package P05MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == number) {
                    output.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }

        if (output.toString().equals("")) {
            System.out.println("not found");
        } else {
            System.out.println(output);
        }
    }

    private static int[][] readMatrix(Scanner scanner) {

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
}
