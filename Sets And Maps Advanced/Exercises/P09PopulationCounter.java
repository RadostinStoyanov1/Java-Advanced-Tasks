package P08SetsAndMapsAdvanced_Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> countriesPopulationMap = new LinkedHashMap<>();
        Map<String, Map<String, Long>> citiesPopulationMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.parseLong(tokens[2]);

            if (!countriesPopulationMap.containsKey(country)) {
                countriesPopulationMap.put(country, 0L);
                citiesPopulationMap.put(country, new LinkedHashMap<>());
            }
            countriesPopulationMap.put(country, countriesPopulationMap.get(country) + population);

            if (!citiesPopulationMap.get(country).containsKey(city)) { //if such city could be put twice as input, would fail
                citiesPopulationMap.get(country).put(city, population);
            }

            input = scanner.nextLine();
        }

        Map<String, Long> outputCountriesMap = new LinkedHashMap<>();
        countriesPopulationMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> outputCountriesMap.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Long> mapEntry : outputCountriesMap.entrySet()) {
            System.out.printf("%s (total population: %d)\n", mapEntry.getKey(), mapEntry.getValue());
            String country = mapEntry.getKey();
            Map<String, Long> outputCitiesMap = new LinkedHashMap<>();
            citiesPopulationMap.get(country).entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> outputCitiesMap.put(x.getKey(), x.getValue()));
            outputCitiesMap.forEach((k, v) -> {
                System.out.printf("=>%s: %d\n", k, v);
            });
        }

    }
}
