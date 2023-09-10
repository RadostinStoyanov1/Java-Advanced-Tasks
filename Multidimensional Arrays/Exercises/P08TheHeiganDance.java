package P06MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        boolean isHeiganBeated = false;
        boolean isPlayerKilled = false;
        int previousTargetRow = -2;
        int previousTargetCol = -2;
        int playerRow = 7;
        int playerCol = 7;
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        String[] spellDetails = new String[3];

        while (playerPoints > 0 && heiganPoints > 0) {

            heiganPoints -= damage;
            if (heiganPoints <= 0) {
                isHeiganBeated = true;
                if (isHit(matrix, playerRow, playerCol, previousTargetRow, previousTargetCol)) { //is player hit by previous cloud?
                    playerPoints -= 3500;
                    previousTargetRow = -2;
                    previousTargetCol = -2;
                }
                break;
            }

            spellDetails = scanner.nextLine().split("\\s+");
            String spellType = spellDetails[0];
            int targetRow = Integer.parseInt(spellDetails[1]);
            int targetCol = Integer.parseInt(spellDetails[2]);

            if (isHit(matrix, playerRow, playerCol, targetRow, targetCol)) { //is player hit?
                if (playerRow - 1 < targetRow - 1 && playerRow - 1 >= 0) { //can player be safe if move up?
                    playerRow--;
                } else if (playerCol + 1 > targetCol + 1 && playerCol + 1 < matrix[playerRow].length) { //safe if move right?
                    playerCol++;
                } else if (playerRow + 1 > targetRow + 1 && playerRow + 1 < matrix.length) { //safe is move down?
                    playerRow++;
                } else if (playerCol - 1 < targetCol - 1 && playerCol - 1 >= 0) {
                    playerCol--;
                } else {
                    if (isHit(matrix, playerRow, playerCol, previousTargetRow, previousTargetCol)) { //is player hit by previous cloud?
                        playerPoints -= 3500;
                        previousTargetRow = -2;
                        previousTargetCol = -2;
                    }
                    if (playerPoints <= 0) {
                        spellDetails[0] = "Plague Cloud";
                        break;
                    } else {
                        if (spellType.contains("Cloud")) {
                            playerPoints -= 3500;
                        } else {
                            playerPoints -= 6000;
                        }
                    }
                }
            }
            if (spellType.equals("Cloud")) {
                previousTargetRow = targetRow;
                previousTargetCol = targetCol;
            }
        }

        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playerPoints <= 0) {
            String spellType = spellDetails[0];
            System.out.printf("Player: Killed by %s%n", spellType);
        } else {
            System.out.printf("Player: %d%n", playerPoints);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);

    }

    private static boolean isHit(int[][] matrix, int playerRow, int playerCol, int targetRow, int targetCol) {
        return (playerRow >= targetRow - 1 && playerRow <= targetRow + 1)
                && (playerCol >= targetCol - 1 && playerCol <= targetCol + 1);
    }
}
