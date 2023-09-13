package P07SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String directions = tokens[0];
            String plateNumber = tokens[1];

            if (directions.equals("IN")) {
                carNumbers.add(plateNumber);
            } else {
                carNumbers.remove(plateNumber);
            }

            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : carNumbers) {
                System.out.println(number);
            }
        }

    }
}
