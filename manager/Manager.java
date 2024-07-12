package manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Inforphone.GenuinePhone;
import Inforphone.ManualPhone;
import Inforphone.Phone;

import java.io.File;
import java.util.Scanner;

public class Manager {
    private static final String NAME_FILE = "D:\baithithuchanh\manageFile\data.txt";
    private List<Phone> phones;

    public Manager() {
        this.phones = new ArrayList<>();
    }

    public static List<Phone> readFilePhone() {
        List<Phone> phones = new ArrayList<>();
        File file = new File(NAME_FILE);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String producer = data[4];

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return phones;
    }

    public static void writeFileBorrower(List<Phone> phones) {
        try {
            File file = new File(NAME_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Phone phone : phones) {
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void addGenuinePhone(Scanner scanner) {
        try {
            System.out.println("Enter phone code");
            int idGenuinePhone = Integer.parseInt(scanner.next());
            System.out.println("Enter name phone");
            String nameGenuinePhone = scanner.nextLine();
            System.out.println("Enter price");
            double priceGenuinePhone = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the product quantity");
            int quantityGenuinePhone = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the manufacturer's name");
            String producerGenuinePhone = scanner.nextLine();
            System.out.println("Enter the warranty period");
            String WarrantyTime = scanner.nextLine();
            System.out.println("Enter warranty coverage");
            String WarrantyScope = scanner.nextLine();
            GenuinePhone genuinePhone = new GenuinePhone(idGenuinePhone, nameGenuinePhone, priceGenuinePhone, quantityGenuinePhone, producerGenuinePhone, WarrantyTime, WarrantyScope);
            addPhone(genuinePhone);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void addManualPhone(Scanner scanner) {
        try {
            System.out.println("Enter phone code");
            int idManualPhone = Integer.parseInt(scanner.next());
            System.out.println("Enter name phone");
            String nameManualPhone = scanner.nextLine();
            System.out.println("Enter price");
            double priceManualPhone = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the product quantity");
            int quantityManualPhone = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the manufacturer's name");
            String producerManualPhone = scanner.nextLine();
            System.out.println("Enter the country name");
            String nation = scanner.nextLine();
            System.out.println("Enter a status name");
            String status = scanner.nextLine();
            ManualPhone manualPhone = new ManualPhone(idManualPhone, nameManualPhone, priceManualPhone, quantityManualPhone, producerManualPhone, nation, status);
            addPhone(manualPhone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeIdPhone( int phoneId) {
        boolean isPhone= false;
            for (Phone phone : phones) {
                if (phone.getId()== phoneId) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Are you sure you want to delete this document? (yes/no): ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        phones.remove(phone);
                        isPhone= true;
                        System.out.println("Document removed successfully.");
                    }
                    else {
                        break;
                    }
                } else {
                    System.out.println("Document removal canceled.");
                }
            }
            if(!isPhone){
                System.out.println("Xoa thất bại");
        }
    }

    public Phone findPhoneById(int  phoneId) {
        for (Phone phone : phones) {
            if (phone.getId()== phoneId) {
                return phone;
            }
        }
        return null;
    }
    public void displayPhone(){
        for(Phone phone: phones){
            System.out.println(phone);
        }
    }
}


