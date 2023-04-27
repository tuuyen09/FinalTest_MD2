package views;

import controller.StudentManager;
import model.Student;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    StudentManager studentManager = new StudentManager();
    InputStudent is = new InputStudent();
    List<Student> students = new ArrayList<>();
    public void menu(){
        do {
            displayMenu();
            int choice = getValidChoice(1, 8);
            switch (choice){
                case 1:
                    studentManager.showStudent();
                    break;
                case 2:
                    studentManager.addNewStudent(is.addStudent());
                    break;
                case 3:
                    studentManager.updateStudent(is.getId(), is.addStudent());
                    break;
                case 4:
                    choiceYesNo();
                    break;
                case 5:
                    displaySortStudent();
                    break;
                case 6:
                    System.out.println(ReadWriteFile.getInstance().readFile());
                    break;
                case 7:
                    ReadWriteFile.getInstance().writeFile(students);
                    break;
                case 8:
                    System.exit(8);
                    break;
            }
        } while (true);
    }
    public void displayMenu(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
        System.out.println("Chọn chức năng theo số (để tiếp tục) ");
        System.out.println("1. Xem danh sách sinh viên.");
        System.out.println("2. Thêm mới.");
        System.out.println("3. Cập nhật.");
        System.out.println("4. Xoá.");
        System.out.println("5. Sắp xếp.");
        System.out.println("6. Đọc từ file.");
        System.out.println("7. Ghi vào file.");
        System.out.println("8. Thoát.");
        System.out.println("Chọn chức năng:");
    }
    public void choiceYesNo(){
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Bạn có chắc chắn xoá? Y/N");
            String choice = input.nextLine();
            switch (choice){
                case "Y":
                    studentManager.deleteStudent(is.getId());
                    break;
                default:
                    return;
            }
        }while (true);
    }
    public void displaySortStudent(){
        do {
            System.out.println("----Sắp xếp sinh viên theo điểm trung bình----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Sắp xếp theo điểm trung bình tăng dần.");
            System.out.println("2. Sắp xếp theo điểm trung bình giảm dần.");
            System.out.println("3. Thoát.");
            System.out.println("Chọn chức năng: ");
            int choice = getValidChoice(1, 3);
            switch (choice){
                case 1:
                    studentManager.sortStudentByGPA();
                    break;
                case 2:
                    studentManager.reverseSort();
                    break;
            }
        }while (true);
    }

    public int getValidChoice(int min, int max){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    scanner.nextLine();
                    return choice;
                }
            }
            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại! ");
            scanner.nextLine();
        }

    }
}
