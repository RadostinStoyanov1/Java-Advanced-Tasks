package ExamPreparationTasks;

import java.util.Scanner;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hazelnuts = 0;
        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");
        boolean isTrap = false;

        char[][] field = createMatrix(size, scanner);
        int squirrelRow = -1;
        int squirrelCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (field[row][col] == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                    break;
                }
            }
        }

        for (String direction : directions) {
            if (direction.equals("left")) {
                if (isInside(squirrelCol - 1, size)) {
                    field[squirrelRow][squirrelCol] = '*';
                    squirrelCol--;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        isTrap = true;
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    System.out.println("The squirrel is out of the field.");
                    isTrap = true;
                    break;
                }
            } else if (direction.equals("right")) {
                if (isInside(squirrelCol + 1, size)) {
                    squirrelCol++;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        isTrap = true;
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    System.out.println("The squirrel is out of the field.");
                    isTrap = true;
                    break;
                }
            } else if (direction.equals("up")) {
                if (isInside(squirrelRow - 1, size)) {
                    squirrelRow--;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        isTrap = true;
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    System.out.println("The squirrel is out of the field.");
                    isTrap = true;
                    break;
                }
            } else if (direction.equals("down")) {
                if (isInside(squirrelRow + 1, size)) {
                    squirrelRow++;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        isTrap = true;
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    System.out.println("The squirrel is out of the field.");
                    isTrap = true;
                    break;
                }
            }
            if (hazelnuts == 3) {
                break;
            }
        }

        if (hazelnuts >= 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
        } else if (!isTrap){
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                char currentSymbol = rowData[col];
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }

    private static boolean isInside(int num, int size) {
        return num >= 0 && num < size;
    }
}
