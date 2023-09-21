package P09StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) {
        File rootFolder = new File("C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> dirsQueue = new ArrayDeque<>();

        dirsQueue.offer(rootFolder);

        int folderCounter = 0;

        while (!dirsQueue.isEmpty()) {
            File currentFile = dirsQueue.poll();
            File[] filesIn = currentFile.listFiles();
            for (File file : filesIn) {
                if (file.isDirectory()) {
                    dirsQueue.offer(file);
                }
            }
            folderCounter++;
            System.out.println(currentFile.getName());
        }
        System.out.printf("%d folders%n", folderCounter);
    }
}
