package P10StreamsFilesAndDirectories_Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\list.ser"));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Rado\\Java Rado\\Test Web Project\\AdvancedModuleTasks\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\list.ser"));

        List<Double> nums = new ArrayList<>();
        Collections.addAll(nums, 1.0, 3.5, 5.3);

        outputStream.writeObject(nums);
        List<Double> serializedNums = (List<Double>) inputStream.readObject();

        serializedNums.forEach(System.out::println);


    }
}
