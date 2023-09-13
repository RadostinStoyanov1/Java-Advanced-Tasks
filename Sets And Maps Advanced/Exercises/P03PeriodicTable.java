package P08SetsAndMapsAdvanced_Exercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsMap = new TreeSet<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            for (String s : input) {
                if (!elementsMap.contains(s)) {
                    elementsMap.add(s);
                }
            }
        }

        String output = String.join(" ", elementsMap);
        System.out.println(output);

    }
}
