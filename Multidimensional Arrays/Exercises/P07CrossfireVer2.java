package P06MultidimensionalArrays_Exercise;

import java.util.*;

public class P07CrossfireVer2 {
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
            int targetRow = Integer.parseInt(details[0]);
            int targetCol = Integer.parseInt(details[1]);
            int radius = Integer.parseInt(details[2]);

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            List<Integer> toRemove = new ArrayList<>();
            toRemove.add(0);
            for (int row = 0; row < matrix.size(); row++) {
                matrix.get(row).removeAll(toRemove);
                if (matrix.get(row).size() == 0) {
                    matrix.remove(row);
                    row--;
                }
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

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        if (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size()) {
            return true;
        } else {
            return false;
        }
    }
}
