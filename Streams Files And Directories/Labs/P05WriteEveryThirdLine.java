package P09StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputTask05.txt";

        FileInputStream inputStream = new FileInputStream(inPath);
        FileOutputStream outputStream = new FileOutputStream(outPath);

        Scanner reader = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outPath);

        int count = 1;
        String line = reader.nextLine();
        while (reader.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;
            line = reader.nextLine();
        }
        writer.close();
    }
}
