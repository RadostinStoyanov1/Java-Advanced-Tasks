package ExamPreparationTasks;

import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizes = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizes][sizes];

        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int currentRow = coordinates[0];
        int currentCol = coordinates[1];
        boolean isSunk = false;
        int fish = 0;

        String command = scanner.nextLine();

        while (!command.equals("collect the nets")) {
            matrix[currentRow][currentCol] = "-";
            if (command.equals("up")) {
                if (isInside(sizes, currentRow - 1, currentCol)) {
                    currentRow--;
                } else {
                    currentRow = sizes - 1;
                }
            } else if (command.equals("down")) {
                if (isInside(sizes, currentRow + 1, currentCol)) {
                    currentRow++;
                } else {
                    currentRow = 0;
                }
            } else if (command.equals("left")) {
                if (isInside(sizes, currentRow, currentCol - 1)) {
                    currentCol--;
                } else {
                    currentCol = sizes - 1;
                }
            } else if (command.equals("right")) {
                if (isInside(sizes, currentRow, currentCol + 1)) {
                    currentCol++;
                } else {
                    currentCol = 0;
                }
            }

            if (matrix[currentRow][currentCol].equals("-")) {
                matrix[currentRow][currentCol] = "S";
            } else if (matrix[currentRow][currentCol].equals("W")) {
                fish = 0;
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]\n", currentRow, currentCol);
                isSunk = true;
                break;
            } else if (Character.isDigit(matrix[currentRow][currentCol].charAt(0))) {
                int amountToAdd = Integer.parseInt(matrix[currentRow][currentCol]);
                fish += amountToAdd;
                matrix[currentRow][currentCol] = "S";
            }

            command = scanner.nextLine();
        }

        if (!isSunk) {
            if (fish >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - fish);
            }

            if (fish > 0) {
                System.out.printf("Amount of fish caught: %d tons.\n", fish);
            }

            printMatrix(matrix);
        }

    }

    private static boolean isInside(int sizes, int currentRow, int currentCol) {
        return currentRow >= 0 & currentRow < sizes && currentCol >= 0 && currentCol < sizes;
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] field, Scanner scanner) {
        int[] coordinates = new int[2];
        boolean isFound = false;
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
            if (!isFound) {
                for (int col = 0; col < field[row].length; col++) {
                    if (field[row][col].equals("S")) {
                        coordinates[0] = row;
                        coordinates[1] = col;
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return coordinates;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
