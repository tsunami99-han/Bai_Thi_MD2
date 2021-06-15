import iocsv.IOPhoneBook;
import management.PhoneBookManagement;
import model.PhoneBook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi ra file");
        System.out.println("8.Thoát");
        System.out.println("Chọn chức năng");
    }

    public static int inputChoie() {
        int choice = 0;
        while (choice == 0) {
            try {
                System.out.println("Nhập lựa chọn :");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Sai kiểu dữ liệu nhập vào!");
            } finally {
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        while (true) {
            menu();
            int choice = inputChoie();
            switch (choice) {
                case 1:
                    phoneBookManagement.display();
                    break;
                case 2:
                    PhoneBook phoneBook=phoneBookManagement.getScannerPhoneBook().creat();
                    phoneBookManagement.add(phoneBook);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại cần tìm");
                    String phoneNum=scanner.nextLine();
                    PhoneBook phoneBook1=phoneBookManagement.find(phoneNum);
                    if (phoneBook1==null){
                        System.out.println("Không tồn tại!");
                    }else {
                        System.out.println(phoneBook1.toString());
                    }
                    break;
                case 6:
                    phoneBookManagement.setList(IOPhoneBook.readFile());
                    break;
                case 7:
                    IOPhoneBook.write(phoneBookManagement.getList());
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn");
            }
        }
    }
}
