package P08SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> set1 = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            set1.add(element);
        }

        Set<String> set2 = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            set2.add(scanner.nextLine());
        }

        set1.retainAll(set2);
        String result = String.join(" ", set1);
        System.out.println(result);
    }
}
