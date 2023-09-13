package P07SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsTreeMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String currentShop = tokens[0];
            String currentProduct = tokens[1];
            double currentProductPrice = Double.parseDouble(tokens[2]);

            if (!shopsTreeMap.containsKey(currentShop)) {
                shopsTreeMap.put(currentShop, new LinkedHashMap<>());
            }

            shopsTreeMap.get(currentShop).put(currentProduct, currentProductPrice);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> mapEntry : shopsTreeMap.entrySet()) {
            System.out.println(mapEntry.getKey() + "->");
            for (Map.Entry<String, Double> entry : mapEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        }

    }
}
