package ExamPreparationTasks;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[size][size];

        int[] coordinates = fillMatrixAndGetCoordinates(field, scanner);
        int currentRow = coordinates[0];
        int currentCol = coordinates[1];
        int flowers = 0;

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            field[currentRow][currentCol] = ".";
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (isOutOfBounds(size, currentRow, currentCol)) {
                System.out.println("The bee got lost!");
                break;
            }
            if (field[currentRow][currentCol].equals("f")) {
                flowers++;
                field[currentRow][currentCol] = "B";
            } else if (field[currentRow][currentCol].equals("O")) {
                field[currentRow][currentCol] = "B";
                continue;
            }

            field[currentRow][currentCol] = "B";

            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowers);
        }
        printMatrix(field);
    }

    private static boolean isOutOfBounds(int size, int currentRow, int currentCol) {
         return currentRow < 0 || currentCol < 0 || currentRow >= size || currentCol >= size;
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] field, Scanner scanner) {
        int[] coordinates = new int[2];
        boolean isFound = false;
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
            if (!isFound) {
                for (int col = 0; col < field.length; col++) {
                    if (field[row][col].equals("B")) {
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
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
