package management;

import model.PhoneBook;
import model.Validation;

import java.util.List;
import java.util.Scanner;

public class ScannerPhoneBook {
    Scanner scanner = new Scanner(System.in);
    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    boolean checkPhoneNumber(String phoneNumber) {
        boolean check = Validation.validate(Validation.PHONE_REGEX, phoneNumber);
        return check;
    }

    boolean checkEmail(String email) {
        boolean check = Validation.validate(Validation.EMAIL_REGEX, email);
        return check;
    }

    boolean checkDateOfBirh(String dateOfBirth) {
        boolean check = Validation.validate(Validation.DATEOFBIRTH_REGEX, dateOfBirth);
        return check;
    }

    public PhoneBook creat() {
        boolean checkNum = false;
        while (checkNum == false) {
            System.out.print("Nhập số điện thoại :");
            String phoneNumber = scanner.nextLine();
            checkNum = checkPhoneNumber(phoneNumber);
            if (checkNum == false) {
                System.err.println("Sai định dạng số điện thoại!Hãy nhập lại");
            }
        }
        System.out.print("Tên nhóm :");
        String group = scanner.nextLine();
        System.out.print("Họ tên :");
        String name = scanner.nextLine();
        System.out.print("Giới tính(Nam/Nữ/Khác.)");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ:");
        String address = scanner.nextLine();
        boolean checkDateOfBith = false;
        String dateOfBith = "";
        while (checkDateOfBith == false) {
            System.out.print("Ngày sinh(dd/mm/yyy) :");
            dateOfBith = scanner.nextLine();
            checkDateOfBith = checkDateOfBirh(dateOfBirth);
            if (checkDateOfBith == false) {
                System.err.println("Sai định dạng ngày sinh, vui lòng nhập lại!");
            }
        }
        boolean checkEmail = false;
        String email = "";
        while (checkEmail == false) {
            System.out.print("Email :");
            email = scanner.nextLine();
            checkEmail = checkEmail(email);
            if (checkEmail == false) {
                System.err.println("Sai đinh dạng,vui lòng nhập lại:");
            }
        }
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, dateOfBirth, email);
        return phoneBook;
    }

    public PhoneBook checkExistPhoneNum(String phoneNumber, List<PhoneBook> phoneBookList) {
        for (PhoneBook phoneBook : phoneBookList) {
            if (phoneBook.getPhoneNumber().equals(phoneNumber)) {
                return phoneBook;
            }
        }
        return null;
    }

    public void delete(String phoneNumber, List<PhoneBook> phoneBookList) {
        PhoneBook check = checkExistPhoneNum(phoneNumber, phoneBookList);
        if (check == null) {
            System.out.println("Số điện thoại không tồn tại!");
        } else {
            System.out.println("Bạn có muốn xóa " + phoneNumber + "\n" + "Nhập lựa chọn(Y.Xóa):");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                phoneBookList.remove(check);
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Hủy việc xóa");
            }
        }
    }

    public void editName(PhoneBook phoneBook) {
        System.out.print("Nhập tên :");
        String name = scanner.nextLine();
        phoneBook.setName(name);
    }

    public void editPhoneNum(PhoneBook phoneBook) {
        String phone = "";
        boolean check = false;
        while (check == false) {
            System.out.print("Nhập số điện thoại :");
            phone = scanner.nextLine();
            check = checkPhoneNumber(phoneNumber);
            if (check == false) {
                System.out.println("Sai định dạng, mời nhập lại");
            }
            phoneBook.setPhoneNumber(phone);
        }

    }

    public void editaddres(PhoneBook phoneBook) {
        System.out.print("Nhập địa chỉ :");
        String address = scanner.nextLine();
        phoneBook.setAddress(address);
    }

    public void editGroup(PhoneBook phoneBook) {
        System.out.print("Nhóm :");
        String group = scanner.nextLine();
        phoneBook.setGroup(group);
    }

    public void editDateOfBirth(PhoneBook phoneBook) {
        boolean check = false;
        String dateOfBirth = "";
        while (check == false) {
            System.out.print("Ngày sinh :");
            dateOfBirth = scanner.nextLine();
            check = checkDateOfBirh(dateOfBirth);
            if (check == false) {
                System.err.println("Sai định dạng ngày sinh,mời nhập lại:");
            }
        }
        phoneBook.setDateOfBirth(dateOfBirth);
    }

    public void editEmail(PhoneBook phoneBook) {
        boolean check = false;
        String email = "";
        while (check == false) {
            System.out.print("Email :");
            email = scanner.nextLine();
            check = checkDateOfBirh(email);
            if (check == false) {
                System.err.println("Sai định dạng email,mời nhập lại:");
            }
        }
        phoneBook.setEmail(email);
    }
}
