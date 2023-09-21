package P10StreamsFilesAndDirectories_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P01SumLinesWithBufferedReader {
    public static void main(String[] args) {
        String pathIn = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathIn))) {
            String line = reader.readLine();
            while (line != null) {
                char[] charsArr = line.toCharArray();
                long sum = 0;
                for (char c : charsArr) {
                    sum += c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
