package ExamPreparationTasks;

import java.util.Scanner;

public class P02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];

        int[] coordinates = fillMatrixAndGetCoordinates(matrix, scanner);
        int currentRow = coordinates[0];
        int currentCol = coordinates[1];

        String command = scanner.nextLine();

        while (!command.equals("danger")) {
            if (command.equals("up")) {
                if (isInMatrix(matrix, currentRow - 1, currentCol)) {
                    matrix[currentRow][currentCol] = "*";
                    currentRow--;
                    if (isWall(matrix, currentRow, currentCol)) {
                        currentRow++;
                        matrix[currentRow][currentCol] = "M";
                        command = scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("No more cheese for tonight!");
                    break;
                }
            } else if (command.equals("down")) {
                if (isInMatrix(matrix, currentRow + 1, currentCol)) {
                    matrix[currentRow][currentCol] = "*";
                    currentRow++;
                    if (isWall(matrix, currentRow, currentCol)) {
                        currentRow--;
                        matrix[currentRow][currentCol] = "M";
                        command = scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("No more cheese for tonight!");
                    break;
                }
            } else if (command.equals("left")) {
                if (isInMatrix(matrix, currentRow, currentCol - 1)) {
                    matrix[currentRow][currentCol] = "*";
                    currentCol--;
                    if (isWall(matrix, currentRow, currentCol)) {
                        currentCol++;
                        matrix[currentRow][currentCol] = "M";
                        command = scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("No more cheese for tonight!");
                    break;
                }
            } else if (command.equals("right")) {
                if (isInMatrix(matrix, currentRow, currentCol + 1)) {
                    matrix[currentRow][currentCol] = "*";
                    currentCol++;
                    if (isWall(matrix, currentRow, currentCol)) {
                        currentCol--;
                        matrix[currentRow][currentCol] = "M";
                        command = scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("No more cheese for tonight!");
                    break;
                }
            }

            if (matrix[currentRow][currentCol].equals("C")) {
                matrix[currentRow][currentCol] = "M";
                if (!isMoreCheese(matrix)) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (matrix[currentRow][currentCol].equals("T")) {
                matrix[currentRow][currentCol] = "M";
                System.out.println("Mouse is trapped!");
                break;
            } else if (matrix[currentRow][currentCol].equals("*")) {
                matrix[currentRow][currentCol] = "M";
            }

            command = scanner.nextLine();
        }

        if (command.equals("danger") && isMoreCheese(matrix)) {
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    private static boolean isWall(String[][] matrix, int currentRow, int currentCol) {
        return matrix[currentRow][currentCol].equals("@");
    }

    private static boolean isMoreCheese(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("C")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isInMatrix(String[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] field, Scanner scanner) {
        int[] coordinates = new int[2];
        boolean isFound = false;
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
            if (!isFound) {
                for (int col = 0; col < field[row].length; col++) {
                    if (field[row][col].equals("M")) {
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
