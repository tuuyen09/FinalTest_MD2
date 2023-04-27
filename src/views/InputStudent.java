package views;

import controller.StudentManager;
import model.Student;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputStudent {

    public InputStudent() {
    }

    public Student addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên:");
        String id = input.nextLine();
        System.out.println("Nhập tên:");
        String name = input.nextLine();
        System.out.println("Nhập tuổi:");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Nhập giới tính:");
        String gender = input.nextLine();
        boolean checkGender = getValidGenger(gender);
        if (!checkGender){
            do {
                System.out.println("Giới tính không hợp lệ! Mời bạn nhập lại giới tính:");
                String newGender = new Scanner(System.in).nextLine();
                checkGender = getValidGenger(newGender);
                if (checkGender){
                    gender = newGender;
                }
            } while (!checkGender);
        }
        System.out.println("Nhập địa chỉ:");
        String address = input.nextLine();
        System.out.println("Nhập điểm trung bình:");
        double gpa = input.nextDouble();
        Student student = new Student(id, name, age, gender, address, gpa);
        return student;
    }

    public String getId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên:");
        String id = input.nextLine();
        return id;
    }

    public boolean getValidGenger (String gender){
        boolean check = false;
        if (gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ") ){
            check = true;
        }
        return check;
    }

}
