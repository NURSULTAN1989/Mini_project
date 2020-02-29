

import java.util.*;
import java.io.*;

public class PackageData implements Serializable{

    ArrayList<Student> studentList;
    Student student;
    String operationType;

    public PackageData(){

    }

    public PackageData(String operationType, Student student) {///Client send information
        this.operationType = operationType;///about ONE student
        this.student = student;
    }

    public PackageData(String operationType) {///LIST: We want to take
        this.operationType = operationType;///information about all students in Database
    }

    public PackageData(ArrayList<Student> studentList) {
        this.studentList = studentList;///Server send back info about all student
    }


}