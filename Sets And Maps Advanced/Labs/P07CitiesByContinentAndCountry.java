package P07SetsAndMapsAdvanced;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());

            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }
        //First way for printing:
        /*for (Map.Entry<String, Map<String, List<String>>> mapEntry : continents.entrySet()) {
            System.out.printf("%s:%n", mapEntry.getKey());
            for (Map.Entry<String, List<String>> entry : mapEntry.getValue().entrySet()) {
                System.out.printf("  %s -> ", entry.getKey());
                System.out.println(String.join(", ", entry.getValue()));
            }
        }*/

        continents.forEach((continent, countryWithCities) -> {
                    System.out.println(continent + ":");

                    countryWithCities.forEach((key, value) -> {
                                System.out.println("  " + key + " -> " + String.join(", ", value));
                            });
                });
    }
}
