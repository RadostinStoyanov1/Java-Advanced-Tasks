package P06MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        //fillMatrixWithZeros(matrix);

        String command = scanner.nextLine();

        while (!command.equals("stop")) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = tokens[0];
            int targetRow = tokens[1];
            int targetCol = tokens[2];
            int actualParkCol = -1;
            boolean foundParkingPlace = false;

            if (matrix[targetRow][targetCol] != 0) {
                int counter = 1;
                while (true) {
                    if (targetCol - counter < 1 && targetCol + counter >= matrix[targetRow].length) {
                        break;
                    }
                    if (targetCol - counter >= 1 && matrix[targetRow][targetCol - counter] == 0) {
                        actualParkCol = targetCol - counter;
                        foundParkingPlace = true;
                        break;
                    } else {
                        if (targetCol + counter < matrix[targetRow].length && matrix[targetRow][targetCol + counter] == 0) {
                            actualParkCol = targetCol + counter;
                            foundParkingPlace = true;
                            break;
                        }
                    }
                    counter++;
                }
            } else {
                actualParkCol = targetCol;
                foundParkingPlace = true;
            }

            // What happens when parking lot is found or row is used:
            if (foundParkingPlace) {
                matrix[targetRow][actualParkCol] = 1;
                int numPassedCells;
                if (entryRow <= targetRow) {
                    numPassedCells = targetRow - entryRow + 1 + actualParkCol;
                } else {
                    numPassedCells = entryRow - targetRow + 1 + actualParkCol;
                }

                System.out.println(numPassedCells);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }
            command = scanner.nextLine();
        }

    }

    private static void fillMatrixWithZeros(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            Arrays.fill(matrix[row], 0);
        }
    }
}
