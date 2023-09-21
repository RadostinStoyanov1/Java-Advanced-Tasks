package P10StreamsFilesAndDirectories_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        int vowelsCount = 0;
        int othersCount = 0;
        int punctuationsCount = 0;

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = List.of('!', '?', '.', ',');

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath))
        ) {
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    if (vowels.contains(currentChar)) {
                        vowelsCount++;
                    } else if (punctuations.contains(currentChar)) {
                        punctuationsCount++;
                    } else if (currentChar != ' ') {
                        othersCount++;
                    }
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Vowels: %d%nOther symbols: %d%nPunctuation: %d%n", vowelsCount, othersCount, punctuationsCount);
    }
}
