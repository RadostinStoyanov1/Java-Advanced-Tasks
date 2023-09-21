package P10StreamsFilesAndDirectories_Exercise;

import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course("Java-Advanced", 300);

        String path = "C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(course);

        //Deserialization:
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        Course deserializedCourse = (Course) inputStream.readObject();
    }
}
