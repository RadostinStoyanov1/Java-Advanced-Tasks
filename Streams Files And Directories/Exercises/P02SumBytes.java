package P10StreamsFilesAndDirectories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn))) {
            int read = reader.read();
            long sum = 0;
            while (read != -1) {
                if (read != 10 && read != 13) {
                    sum += read;
                }
                read = reader.read();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
