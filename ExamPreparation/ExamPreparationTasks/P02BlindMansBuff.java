package ExamPreparationTasks;

import java.util.Scanner;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int foundPlayers = 0;
        long movesCount = 0;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = input;
        }

        int[] startPosition = getStartPosition(matrix);
        int currentRow = startPosition[0];
        int currentCol = startPosition[1];

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            if (command.equals("up")) {
                if (checkNewPosition(matrix, currentRow - 1, currentCol)) {
                    currentRow--;
                } else {
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("down")) {
                if (checkNewPosition(matrix, currentRow + 1, currentCol)) {
                    currentRow++;
                } else {
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("right")) {
                if (checkNewPosition(matrix, currentRow, currentCol + 1)) {
                    currentCol++;
                } else {
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("left")) {
                if (checkNewPosition(matrix, currentRow, currentCol - 1)) {
                    currentCol--;
                } else {
                    command = scanner.nextLine();
                    continue;
                }
            }
            movesCount++;

            if (matrix[currentRow][currentCol] == 'P') {
                foundPlayers++;
                matrix[currentRow][currentCol] = '-';
            }

            if (foundPlayers == 3) {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", foundPlayers, movesCount);

    }

    private static boolean checkNewPosition(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] != 'O';
    }

    private static int[] getStartPosition(char[][] field) {
        int[] arr = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'B') {
                    arr[0] = row;
                    arr[1] = col;
                }
            }
        }
        return arr;
    }
}
