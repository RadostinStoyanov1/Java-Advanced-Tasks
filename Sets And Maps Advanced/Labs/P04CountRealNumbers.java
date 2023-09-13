package P07SetsAndMapsAdvanced;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersWithOccurencies = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(e -> {
                    if (!numbersWithOccurencies.containsKey(e)) {
                        numbersWithOccurencies.put(e, 1);
                    } else {
                        numbersWithOccurencies.put(e, numbersWithOccurencies.get(e) + 1);
                    }
                });

        for (var entry : numbersWithOccurencies.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
