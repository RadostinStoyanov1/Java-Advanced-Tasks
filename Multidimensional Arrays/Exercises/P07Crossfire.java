package P06MultidimensionalArrays_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;

        for (int row = 0; row < rows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(counter++);
            }
            matrix.add(rowList);
        }

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] details = command.split("\\s+");
            int row = Integer.parseInt(details[0]);
            int col = Integer.parseInt(details[1]);
            int radius = Integer.parseInt(details[2]);

            row = deleteUp(matrix, row, col, radius);
            deleteDown(matrix, row, col, radius);
            deleteRight(matrix, row, col, radius);
            col = deleteLeft(matrix, row, col, radius);

            matrix.get(row).remove(col);
            if (matrix.get(row).size() == 0) {
                matrix.remove(row);
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int rowM = 0; rowM < matrix.size(); rowM++) {
            for (int colM = 0; colM < matrix.get(rowM).size(); colM++) {
                System.out.print(matrix.get(rowM).get(colM) + " ");
            }
            System.out.println();
        }
    }

    private static int deleteLeft(List<List<Integer>> matrix, int row, int col, int radius) {
        if (col == 0) {
            return col;
        }
        for (int i = 1; i <= radius; i++) {
            if (col - 1 < 0) {
                return col;
            }
            if (matrix.get(row).get(col - 1) >= 0) {
                matrix.get(row).remove(col - 1);
                col--;
            }
        }
        return col;
    }

    private static void deleteRight(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = 1; i <= radius; i++) {
            if ((col + 1) < matrix.get(row).size()) {
                matrix.get(row).remove(col + 1);
            }
        }
    }

    private static void deleteDown(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = 1; i <= radius; i++) {
            if ((row + i) < matrix.size() && col < matrix.get(row + i).size()) {
                matrix.get(row + i).remove(col);
                if (matrix.get(row + i).size() == 0) {
                    matrix.remove(row + i);
                    i--;
                    radius--;
                }
            }
        }
    }

    private static int deleteUp(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = 1; i <= radius; i++) {
            if ((row - i) >= 0 && col < matrix.get(row - i).size()) {
                matrix.get(row - i).remove(col);
                if (matrix.get(row - 1).size() == 0) {
                    matrix.remove(row - 1);
                    row--;
                    i--;
                    radius--;
                }
            }

        }
        return row;
    }
}
