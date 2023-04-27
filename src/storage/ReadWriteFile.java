package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private ReadWriteFile(){}
    private static ReadWriteFile readWriteFile = null;
    public static ReadWriteFile getInstance(){
        if (readWriteFile == null) readWriteFile = new ReadWriteFile();
        return readWriteFile;
    }
    public void writeFile(List<Student> students){
        File file = new File("student.csv");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            fos.close();
            oos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
 public List<Student> readFile (){
        List<Student> students = new ArrayList<>();
        try {
            File file = new File("student.csv");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
