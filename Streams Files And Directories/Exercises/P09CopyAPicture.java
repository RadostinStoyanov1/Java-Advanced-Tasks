package P10StreamsFilesAndDirectories_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class P09CopyAPicture {
    public static void main(String[] args) {
        String inPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\pic.jpg";
        String output = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\pic-copy.jpg";

        try (FileInputStream inputStream = new FileInputStream(inPath);
             FileOutputStream outputStream = new FileOutputStream(output)
        ) {
            Files.copy(Path.of(inPath), outputStream);

            /*int currentByte = inputStream.read();
            while (currentByte != -1) {
                outputStream.write(currentByte);
                currentByte = inputStream.read();
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
