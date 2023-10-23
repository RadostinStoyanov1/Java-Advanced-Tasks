package ExamPreparationTasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> movements = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        char[][] matrix = new char[n][n];

        fillMatrix(matrix, scanner);

        int currentRow = -1;
        int currentCol = -1;
        int previousRow;
        int previousCol;
        int totalMoney = 0;
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            if (isFound) {
                break;
            }
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'D') {
                    currentRow = row;
                    currentCol = col;
                    isFound = true;
                    break;
                }
            }
        }

        while (!movements.isEmpty()) {
            previousRow = currentRow;
            previousCol = currentCol;
            if (movements.get(0).equals("left")) {
                if (isIn(matrix, currentRow, currentCol - 1)) {
                    currentCol--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                    movements.remove(0);
                    continue;
                }
            } else if (movements.get(0).equals("right")) {
                if (isIn(matrix, currentRow, currentCol + 1)) {
                    currentCol++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                    movements.remove(0);
                    continue;
                }
            } else if (movements.get(0).equals("up")) {
                if (isIn(matrix, currentRow - 1, currentCol)) {
                    currentRow--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                    movements.remove(0);
                    continue;
                }
            } else if (movements.get(0).equals("down")) {
                if (isIn(matrix, currentRow + 1, currentCol)) {
                    currentRow++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                    movements.remove(0);
                    continue;
                }
            }

            if (matrix[currentRow][currentCol] == '$') {
                matrix[previousRow][previousCol] = '+';
                matrix[currentRow][currentCol] = 'D';
                totalMoney += currentRow * currentCol;
                System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
            } else if (matrix[currentRow][currentCol] == 'P') {
                matrix[previousRow][previousCol] = '+';
                matrix[currentRow][currentCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
                break;
            } else if (matrix[currentRow][currentCol] == '+') {
                matrix[previousRow][previousCol] = '+';
                matrix[currentRow][currentCol] = 'D';
            }

            movements.remove(0);
        }
        if (movements.isEmpty()) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalMoney);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = matrix[row];
            for (int col = 0; col < currentRow.length; col++) {
                System.out.print(currentRow[col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isIn(char[][] matrix, int currentRow, int currentCol) {
        if (currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix.length) {
            return true;
        }
        return false;
    }


    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = currentRow;
        }
    }
}
