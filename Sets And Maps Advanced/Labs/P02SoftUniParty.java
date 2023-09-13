package P07SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();

        String reservationNumber = scanner.nextLine();

        while (!reservationNumber.equals("PARTY")) {
            guest.add(reservationNumber);
            reservationNumber = scanner.nextLine();
        }

        reservationNumber = scanner.nextLine();

        while (!reservationNumber.equals("END")) {
            guest.remove(reservationNumber);
            reservationNumber = scanner.nextLine();
        }

        System.out.println(guest.size());

        for (String s : guest) {
            System.out.println(s);
        }
    }
}
