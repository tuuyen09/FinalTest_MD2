package controller;

import model.Student;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    public List<Student> students = ReadWriteFile.getInstance().readFile();

    public void showStudent() {
        students.forEach(System.out::println);
    }

    public void addNewStudent(Student student) {
        boolean check = true;
        if(student.getGpa() >= 0 && student.getGpa() <= 10) {
            for (Student student1 : students) {
                if (student.getId().equals(student1.getId())) {
                    System.out.println("Mã sinh viên đã tồn tại!");
                    check = false;
                }
                if (check) {
                    students.add(student);
                    ReadWriteFile.getInstance().writeFile(students);
                }
            }
        }else {
            System.out.println("Điểm không hợp lệ!");
        }
    }

    public void updateStudent(String id, Student newStudent) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                System.out.println(students.get(i));
                students.set(students.indexOf(students.get(i)), newStudent);
                check = true;
            }
        }
        if (check) {
            System.out.println("Không tìm được mã sinh viên trên!");
        }
    }

    public void deleteStudent(String id) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                students.remove(students.get(i));
                check = true;
            }
        }
        if (check) {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên!");
        }
    }

    public void sortStudentByGPA() {
        students.sort(new SortStudentByGPA());
        students.forEach(System.out::println);
    }

    public void reverseSort() {
        students.sort(new SortStudentByGPA());
        Collections.reverse(students);
        students.forEach(System.out::println);
    }
}
