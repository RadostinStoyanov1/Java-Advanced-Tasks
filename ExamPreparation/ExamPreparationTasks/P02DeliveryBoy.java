package ExamPreparationTasks;

import java.util.Arrays;
import java.util.Scanner;

public class P02DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        int[] startCoordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int startRow = startCoordinates[0];
        int startCol = startCoordinates[1];
        int currentRow = startRow;
        int currentCol = startCol;

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                if (isInField(matrix, currentRow - 1, currentCol)) {
                    currentRow--;
                    if (matrix[currentRow][currentCol].equals("*")) {
                        currentRow++;
                        continue;
                    }
                    if (!matrix[currentRow + 1][currentCol].equals("R")) {
                        matrix[currentRow + 1][currentCol] = ".";
                    }
                } else {
                    System.out.println("The delivery is late. Order is canceled.");
                    matrix[startRow][startCol] = " ";
                    if (!matrix[currentRow][currentCol].equals("R")) {
                        matrix[currentRow][currentCol] = ".";
                    }
                    break;
                }
            } else if (command.equals("down")) {
                if (isInField(matrix, currentRow + 1, currentCol)) {
                    currentRow++;
                    if (matrix[currentRow][currentCol].equals("*")) {
                        currentRow--;
                        continue;
                    }
                    if (!matrix[currentRow - 1][currentCol].equals("R")) {
                        matrix[currentRow - 1][currentCol] = ".";
                    }
                } else {
                    System.out.println("The delivery is late. Order is canceled.");
                    matrix[startRow][startCol] = " ";
                    if (!matrix[currentRow][currentCol].equals("R")) {
                        matrix[currentRow][currentCol] = ".";
                    }
                    break;
                }
            } else if (command.equals("left")) {
                if (isInField(matrix, currentRow, currentCol - 1)) {
                    currentCol--;
                    if (matrix[currentRow][currentCol].equals("*")) {
                        currentCol++;
                        continue;
                    }
                    if (!matrix[currentRow][currentCol + 1].equals("R")) {
                        matrix[currentRow][currentCol + 1] = ".";
                    }
                } else {
                    System.out.println("The delivery is late. Order is canceled.");
                    matrix[startRow][startCol] = " ";
                    if (!matrix[currentRow][currentCol].equals("R")) {
                        matrix[currentRow][currentCol] = ".";
                    }
                    break;
                }
            } else if (command.equals("right")) {
                if (isInField(matrix, currentRow, currentCol + 1)) {
                    currentCol++;
                    if (matrix[currentRow][currentCol].equals("*")) {
                        currentCol--;
                        continue;
                    }
                    if (!matrix[currentRow][currentCol - 1].equals("R")) {
                        matrix[currentRow][currentCol - 1] = ".";
                    }
                } else {
                    System.out.println("The delivery is late. Order is canceled.");
                    matrix[startRow][startCol] = " ";
                    if (!matrix[currentRow][currentCol].equals("R")) {
                        matrix[currentRow][currentCol] = ".";
                    }
                    break;
                }
            }

            if (matrix[currentRow][currentCol].equals("-") || matrix[currentRow][currentCol].equals(".")) {
                matrix[currentRow][currentCol] = "B";
            } else if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[currentRow][currentCol].equals("A")) {
                matrix[currentRow][currentCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                matrix[startRow][startCol] = "B";
                break;
            }
        }

        printMatrix(matrix);

    }

    private static boolean isInField(String[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >=  0 && currentCol < matrix[currentRow].length;
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] field, Scanner scanner) {
        int[] coordinates = new int[2];
        boolean isFound = false;
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
            if (!isFound) {
                for (int col = 0; col < field[row].length; col++) {
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
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
