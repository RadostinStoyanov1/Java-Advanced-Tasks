package P08SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class P07HandsOfCards {
    private static Map<String, Integer> multipliers = new HashMap<>();
    private static Map<String, Integer> cardsPowers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        multipliers.put("S", 4);
        multipliers.put("H", 3);
        multipliers.put("D", 2);
        multipliers.put("C", 1);

        cardsPowers.put("2", 2);
        cardsPowers.put("3", 3);
        cardsPowers.put("4", 4);
        cardsPowers.put("5", 5);
        cardsPowers.put("6", 6);
        cardsPowers.put("7", 7);
        cardsPowers.put("8", 8);
        cardsPowers.put("9", 9);
        cardsPowers.put("10", 10);
        cardsPowers.put("J", 11);
        cardsPowers.put("Q", 12);
        cardsPowers.put("K", 13);
        cardsPowers.put("A", 14);

        Map<String, HashSet<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            if (!playersCards.containsKey(name)) {
                playersCards.put(name, new HashSet<>());
            }

            for (String card : cards) {
                playersCards.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        playersCards.forEach((name, cards) -> {
            int sumPoints = calculatePoints(cards);
            System.out.printf("%s: %d\n", name, sumPoints);
        });

    }

    private static int calculatePoints(HashSet<String> cards) {
        int sumPoints = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String multiplier = card.substring(card.length() - 1);
            sumPoints += cardsPowers.get(power) * multipliers.get(multiplier);
        }
        return sumPoints;
    }
}
