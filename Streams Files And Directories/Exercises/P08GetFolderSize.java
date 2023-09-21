package P10StreamsFilesAndDirectories_Exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P08GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] allFiles = folder.listFiles();
                long sum = 0;
                for (File file : allFiles) {
                    sum += file.length();
                }
                System.out.printf("Folder size: %d", sum);
            }
        }
    }
}
