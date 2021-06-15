package management;

import model.PhoneBook;

import java.util.List;

public class PhoneBookManagement implements GerenalManagement<PhoneBook> {
    List<PhoneBook> list;
    ScannerPhoneBook scannerPhoneBook = new ScannerPhoneBook();

    @Override
    public void display() {
        for (PhoneBook phoneBook : list) {
            System.out.println(phoneBook.toString());
        }
    }

    @Override
    public void add(PhoneBook telephoneDirectory) {
        list.add(telephoneDirectory);
    }

    @Override
    public void edit(String st) {
    }

    public void setList(List<PhoneBook> list) {
        this.list = list;
    }

    @Override
    public void delete(String st) {
        scannerPhoneBook.delete(st, list);
    }

    public ScannerPhoneBook getScannerPhoneBook() {
        return scannerPhoneBook;
    }

    public List<PhoneBook> getList() {
        return list;
    }

    @Override
    public PhoneBook find(String st) {
        for (PhoneBook phoneBook: list){
            if (st.contains(phoneBook.getPhoneNumber())){
                return phoneBook;
            }
        }
        return null;
    }
}
