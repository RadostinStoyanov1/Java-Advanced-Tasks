package ExamPreparationTasks;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("P")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (isValid(matrix, currentRow - 1, currentCol)) {
                        matrix[currentRow][currentCol] = "-";
                        currentRow--;
                    } else {
                        word = removeLastChar(word);
                    }
                    break;
                case "down":
                    if (isValid(matrix, currentRow + 1, currentCol)) {
                        matrix[currentRow][currentCol] = "-";
                        currentRow++;
                    } else {
                        word = removeLastChar(word);
                    }
                    break;
                case "left":
                    if (isValid(matrix, currentRow, currentCol - 1)) {
                        matrix[currentRow][currentCol] = "-";
                        currentCol--;
                    } else {
                        word = removeLastChar(word);
                    }
                    break;
                case "right":
                    if (isValid(matrix, currentRow, currentCol + 1)) {
                        matrix[currentRow][currentCol] = "-";
                        currentCol++;
                    } else {
                        word = removeLastChar(word);
                    }
                    break;
            }
            if (!matrix[currentRow][currentCol].equals("-") && !matrix[currentRow][currentCol].equals("P")) {
                word = word + matrix[currentRow][currentCol];
            }
            matrix[currentRow][currentCol] = "P";

            command = scanner.nextLine();
        }
        System.out.println(word);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String removeLastChar(String word) {
        if (word.length() > 0) {
            return word.substring(0, word.length() - 1);
        }
        return word;
    }

    private static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

    }
}
