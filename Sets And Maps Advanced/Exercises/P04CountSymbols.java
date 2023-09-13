package P08SetsAndMapsAdvanced_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> charsMap = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!charsMap.containsKey(symbol)) {
                charsMap.put(symbol, 1);
            } else {
                charsMap.put(symbol, charsMap.get(symbol) + 1);
            }
        }

        charsMap.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));

    }
}
