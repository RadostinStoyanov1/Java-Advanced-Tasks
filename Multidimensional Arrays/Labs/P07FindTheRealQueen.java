package P05MultidimensionalArrays;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[i] = arr;
        }

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            if (isFound) {
                break;
            }

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    boolean isFalseQueen = false;
                    for (int i = 0; i < matrix[row].length; i++) { //check horizontally
                        if (i == col) {
                            continue;
                        }
                        if (matrix[row][i] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                    }
                    if (isFalseQueen) {
                        continue;
                    }

                    for (int i = 0; i < matrix.length; i++) { //check vertically
                        if (i == row) {
                            continue;
                        }

                        if (matrix[i][col] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                    }
                    if (isFalseQueen) {
                        continue;
                    }

                    int rowPosition = row;
                    int colPosition = col;

                    while (rowPosition >= 0 && rowPosition < 8 && colPosition >= 0 && colPosition < 8) {
                        if (rowPosition == row && colPosition == col) {
                            rowPosition--;
                            colPosition--;
                            continue;
                        }

                        if (matrix[rowPosition][colPosition] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                        rowPosition--;
                        colPosition--;
                    }

                    if (isFalseQueen) {
                        continue;
                    }

                    while (rowPosition >= 0 && rowPosition < 8 && colPosition >= 0 && colPosition < 8) {
                        if (rowPosition == row && colPosition == col) {
                            rowPosition++;
                            colPosition++;
                            continue;
                        }

                        if (matrix[rowPosition][colPosition] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                        rowPosition++;
                        colPosition++;
                    }

                    if (isFalseQueen) {
                        continue;
                    }

                    while (rowPosition >= 0 && rowPosition < 8 && colPosition >= 0 && colPosition < 8) {
                        if (rowPosition == row && colPosition == col) {
                            rowPosition++;
                            colPosition--;
                            continue;
                        }

                        if (matrix[rowPosition][colPosition] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                        rowPosition++;
                        colPosition--;
                    }

                    if (isFalseQueen) {
                        continue;
                    }

                    while (rowPosition >= 0 && rowPosition < 8 && colPosition >= 0 && colPosition < 8) {
                        if (rowPosition == row && colPosition == col) {
                            rowPosition--;
                            colPosition++;
                            continue;
                        }

                        if (matrix[rowPosition][colPosition] == 'q') {
                            isFalseQueen = true;
                            break;
                        }
                        rowPosition--;
                        colPosition++;
                    }

                    if (!isFalseQueen) {
                        isFound = true;
                        System.out.print(row + " " + col);
                        break;
                    }

                }
            }
        }

    }
}
