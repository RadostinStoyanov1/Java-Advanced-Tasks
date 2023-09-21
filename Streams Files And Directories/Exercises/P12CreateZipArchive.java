package P10StreamsFilesAndDirectories_Exercise;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String inPath1 = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String inPath2 = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String inPath3 = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String outputPath = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(inPath1, inPath2, inPath3);
        FileOutputStream fos = new FileOutputStream(outputPath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        for (String path : paths) {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file); //creating a stream of files, not byte by byte
            ZipEntry zipEntry = new ZipEntry(file.getName()); //the file, which will zip
            zos.putNextEntry(zipEntry);

            int read = fis.read();
            while (read != -1) {
                zos.write(read);
                read = fis.read();
            }
            fis.close();
        }
        zos.close();
        fos.close();
    }
}
