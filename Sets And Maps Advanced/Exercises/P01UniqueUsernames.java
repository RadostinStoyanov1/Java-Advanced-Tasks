package P08SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> namesSet = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            String userName  = scanner.nextLine();
            namesSet.add(userName);
        }

        namesSet.forEach(System.out::println);

    }
}
