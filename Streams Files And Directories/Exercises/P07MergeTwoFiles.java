package P10StreamsFilesAndDirectories_Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        String inPath1 = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inPath2 = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inPath1));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))
        ) {
            String line = reader1.readLine();
            while (line != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
                line = reader1.readLine();
            }

            line = reader2.readLine();
            while (line != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
                line = reader2.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
