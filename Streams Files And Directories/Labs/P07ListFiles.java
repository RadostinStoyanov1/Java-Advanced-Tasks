package P09StreamsFilesAndDirectories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (folder.exists()) { //if such file/folder exists
            if (folder.isDirectory()) { //if "folder" is directory
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%s]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
