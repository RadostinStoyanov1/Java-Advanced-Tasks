package ExamPreparationTasks;

import java.util.*;
import java.util.stream.Collectors;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowels::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonants::push);

        List<String> words = new ArrayList(List.of("pear", "flour", "pork", "olive"));
        List<String> foundWords = new ArrayList<>(List.of("____", "_____", "____", "_____"));

        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();
            vowels.offer(vowel);

            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i);
                if (currentWord.contains(vowel)) {
                    int vowelIndex = getIndex(currentWord, vowel);
                    String word = foundWords.get(i);
                    String newWord = word.substring(0, vowelIndex) + vowel;
                    if (vowelIndex < word.length() - 1) {
                        newWord = newWord + word.substring(vowelIndex + 1);
                    }
                    foundWords.set(i, newWord);
                }
                if (currentWord.contains(consonant)) {
                    int consonantIndex = getIndex(currentWord, consonant);
                    String word = foundWords.get(i);
                    String newWord = word.substring(0, consonantIndex) + consonant;
                    if (consonantIndex < word.length() - 1) {
                        newWord  = newWord + word.substring(consonantIndex + 1);
                    }
                    foundWords.set(i, newWord);
                }
            }
        }

        List<String> finalList = foundWords.stream().filter(e -> !e.contains("_")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", finalList.size());
        finalList.forEach(System.out::println);

    }

    private static int getIndex(String currentWord, String letter) {
        int index = currentWord.indexOf(letter);
        return index;
    }
}
