package P07SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);

            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (firstCard < secondCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }

        String output = "Draw!";
        if(firstPlayer.size() > secondPlayer.size()) {
            output = "First player win!";
        } else if (firstPlayer.size() < secondPlayer.size()) {
            output = "Second player win!";
        }
        System.out.println(output);
    }
}
