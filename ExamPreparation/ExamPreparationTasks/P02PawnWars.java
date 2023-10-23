package ExamPreparationTasks;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];
        int whiteRow = -1;
        int whiteCol = -1;
        int blackRow = -1;
        int blackCol = -1;
        boolean isWhiteFound = false;
        boolean isBlackFound = false;
        boolean whitePawnBeat = false;
        boolean blackPawnBeat = false;

        for (int row = 0; row < board.length; row++) {
            char[] currentRaw = scanner.nextLine().toCharArray();
            board[row] = currentRaw;
            if (!isWhiteFound || !isBlackFound) {
                for (int col = 0; col < currentRaw.length; col++) {
                    if (board[row][col] == 'w') {
                        whiteRow = row;
                        whiteCol = col;
                        isWhiteFound = true;
                    } else if (board[row][col] == 'b') {
                        blackRow = row;
                        blackCol = col;
                        isBlackFound = true;
                    }
                }
            }
        }

        while (whiteRow > 0 && blackRow < board.length - 1) {
            int whiteResult = isBlackPawnDiagonally(board, whiteRow, whiteCol);
            board[whiteRow][whiteCol] = '-';
            if (whiteResult < 0) {
                whiteRow--;
                whiteCol--;
                whitePawnBeat = true;
                break;
            } else if (whiteResult > 0) {
                whiteRow--;
                whiteCol++;
                whitePawnBeat = true;
                break;
            } else {
                whiteRow--;
            }
            board[whiteRow][whiteCol] = 'w';
            
            int blackResult = isWhitePawnDiagonally(board, blackRow, blackCol);
            board[blackRow][blackCol] = '-';
            if (blackResult < 0) {
                blackRow++;
                blackCol--;
                blackPawnBeat = true;
                break;
            } else if (blackResult > 0) {
                blackRow++;
                blackCol++;
                blackPawnBeat = true;
                break;
            } else {
                blackRow++;
            }
            board[blackRow][blackCol] = 'b';
        }
        char whiteColumn = (char) (97 + whiteCol);
        char blackColumn = (char) (97 + blackCol);
        String whitePosition = "" + whiteColumn + (8 - whiteRow);
        String blackPosition = "" + blackColumn + (8 - blackRow);

        if (whitePawnBeat) {
            System.out.printf("Game over! White capture on %s.\n", whitePosition);
        } else if (blackPawnBeat) {
            System.out.printf("Game over! Black capture on %s.\n", blackPosition);
        } else if (whiteRow == 0) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.\n", whitePosition);
        } else if (blackRow == board.length - 1) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.\n", blackPosition);
        }


    }

    private static int isWhitePawnDiagonally(char[][] board, int blackRow, int blackCol) {
        if (validPosition(board, blackRow + 1, blackCol - 1)) { //left diagonal for black pawn
            if (board[blackRow + 1][blackCol - 1] == 'w') {
                return -1;
            }
        } else if (validPosition(board, blackRow + 1, blackCol + 1)) { //right diagonal for black pawn
            if (board[blackRow + 1][blackCol + 1] == 'w') {
                return 1;
            }
        }
        return 0;
    }

    private static int isBlackPawnDiagonally(char[][] board, int whiteRow, int whiteCol) {
        if (validPosition(board, whiteRow - 1, whiteCol - 1)) { //left diagonal for white pawn
            if (board[whiteRow - 1][whiteCol - 1] == 'b') {
                return -1;
            }
        } else if (validPosition(board, whiteRow - 1, whiteCol + 1)) { //right diagonal for white pawn
            if (board[whiteRow - 1][whiteCol + 1] == 'b') {
                return 1;
            }
        }
        return 0;
    }

    private static boolean validPosition(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }
}
