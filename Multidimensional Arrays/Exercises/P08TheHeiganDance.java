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
        boolean activeCloud = false;
        String spellType = "";
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

            if (activeCloud) { //is player hit by previous cloud?
                playerPoints -= 3500;
                activeCloud = false;

                if (playerPoints < 0) {
                    isPlayerKilled = true;
                    break;
                }
            }

            if (heiganPoints < 0) {
                isHeiganBeated = true;
                break;
            }

            spellDetails = scanner.nextLine().split("\\s+");
            spellType = spellDetails[0];
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
                }

                if (isHit(matrix, playerRow, playerCol, targetRow, targetCol)) {
                    if (spellType.contains("Cloud")) { //Hit by Plague Cloud
                        playerPoints -= 3500;
                        spellType = "Plague Cloud";
                        activeCloud = true;
                    } else { // Hit by Eruption
                        playerPoints -= 6000;
                    }
                }

            }
        }

        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playerPoints <= 0) {
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
