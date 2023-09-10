package P06MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        readStringMatrix(scanner, matrix);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (command.startsWith("swap")) {
                String[] tokens = command.split("\\s+");
                if (tokens.length == 5) {
                    int row1 = Integer.parseInt(tokens[1]);
                    int col1 = Integer.parseInt(tokens[2]);
                    int row2 = Integer.parseInt(tokens[3]);
                    int col2 = Integer.parseInt(tokens[4]);

                    if (row1 >=0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols) {
                        String firstElement = matrix[row1][col1];
                        String secondElement = matrix[row2][col2];
                        String tempElement = secondElement;
                        matrix[row2][col2] = matrix[row1][col1];
                        matrix[row1][col1] = tempElement;
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                        command = scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("Invalid input!");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void readStringMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[row] = arr;
        }
    }
}
