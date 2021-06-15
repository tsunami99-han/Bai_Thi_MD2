package iocsv;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPhoneBook {
    public static final String PATH = "D:\\02_Module2\\Bai_Thi_MD2\\Bai1\\src\\bookphone.csv";

    public static void write(List<PhoneBook> list) {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email";
            for (PhoneBook phoneBook : list) {
                str += phoneBook.getPhoneNumber() + "," + phoneBook.getGroup() + "," + phoneBook.getName() + "," + phoneBook.getGender() + "," + phoneBook.getAddress() + "," + phoneBook.getDateOfBirth() + "," + phoneBook.getEmail() + "\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<PhoneBook> read(){
        List<PhoneBook> list=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String content=bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
            while ((content=bufferedReader.readLine())!=null){
                String[] values=content.split(",");
                PhoneBook phoneBook=new PhoneBook(values[0],values[1],values[2],values[3],values[4],values[5],values[6]);
                list.add(phoneBook);
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
