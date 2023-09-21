package P10StreamsFilesAndDirectories_Exercise;

import java.io.Serializable;

public class Course implements Serializable {
    String name;
    int studentsNum;

    public Course(String name, int studentsNum) {
        this.name = name;
        this.studentsNum = studentsNum;
    }
}
