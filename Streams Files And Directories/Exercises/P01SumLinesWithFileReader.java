package P10StreamsFilesAndDirectories_Exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P01SumLinesWithFileReader {
    public static void main(String[] args) {
        String pathIn = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (FileReader fileReader = new FileReader(pathIn)) {
             Scanner scanner = new Scanner(fileReader);

             while (scanner.hasNext()) {
                 String line = scanner.nextLine();

                 char[] charsArr = line.toCharArray();
                 long sum = 0;
                 for (char c : charsArr) {
                     sum += c;
                 }
                 System.out.println(sum);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
