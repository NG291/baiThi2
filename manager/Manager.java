package manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Inforphone.GenuinePhone;
import Inforphone.ManualPhone;
import Inforphone.Phone;

import java.io.File;
import java.util.Scanner;

public class Manager {
    private static final String NAME_FILE = "manageFile\\data.csv";
    private List<Phone> phones;
    private static int nextId = 1;

    public Manager() {
        this.phones =  readFilePhone();
    }

    public static List<Phone> readFilePhone() {
        List<Phone> phones = new ArrayList<>();
        File file = new File(NAME_FILE);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double price = Double.parseDouble(data[2].trim());
                int quantity = Integer.parseInt(data[3].trim());
                String producer = data[4].trim();

                if (data.length == 7) { // GenuinePhone
                    int warrantyTime = Integer.parseInt(data[5].trim());
                    String warrantyScope = data[6].trim();
                    phones.add(new GenuinePhone(id, name, price, quantity, producer, warrantyTime, warrantyScope));
                } else if (data.length == 8) { // ManualPhone
                    String nation = data[5].trim();
                    String status = data[6].trim();
                    phones.add(new ManualPhone(id, name, price, quantity, producer, nation,status));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return phones;
    }


    public static void writeFilePhone(List<Phone> phones) {
        try {
            File file = new File(NAME_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Phone phone : phones) {
                bufferedWriter.write(phone.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void addPhone(Phone phone) {
        phone.setId(nextId++);
        phones.add(phone);
        writeFilePhone(phones);
    }

    public void addGenuinePhone(Scanner scanner) {
        try {
            System.out.println("Enter name phone");
            String nameGenuinePhone = scanner.nextLine();
            System.out.println("Enter price");
            double priceGenuinePhone = Double.parseDouble(scanner.nextLine());
            Validator.validatePrice(priceGenuinePhone);
            System.out.println("Enter the product quantity");
            int quantityGenuinePhone = Integer.parseInt(scanner.nextLine());
            Validator.validateQuantity(quantityGenuinePhone);
            System.out.println("Enter the manufacturer's name");
            String producerGenuinePhone = scanner.nextLine();
            System.out.println("Enter the warranty period");
            int warrantyTime = Integer.parseInt(scanner.nextLine());
            Validator.validateWarrantyPeriod(warrantyTime);
            System.out.println("Enter warranty coverage");
            String WarrantyScope = scanner.nextLine();
            GenuinePhone genuinePhone = new GenuinePhone(nextId, nameGenuinePhone, priceGenuinePhone, quantityGenuinePhone, producerGenuinePhone, warrantyTime, WarrantyScope);
            addPhone(genuinePhone);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void addManualPhone(Scanner scanner) {
        try {
            System.out.println("Enter name phone");
            String nameManualPhone = scanner.nextLine();
            System.out.println("Enter price");
            double priceManualPhone = Double.parseDouble(scanner.nextLine());
            Validator.validatePrice(priceManualPhone);
            System.out.println("Enter the product quantity");
            int quantityManualPhone = Integer.parseInt(scanner.nextLine());
            Validator.validateQuantity(quantityManualPhone);
            System.out.println("Enter the manufacturer's name");
            String producerManualPhone = scanner.nextLine();
            System.out.println("Enter the country name");
            String nation = scanner.nextLine();
            System.out.println("Enter a status name");
            String status = scanner.nextLine();
            ManualPhone manualPhone = new ManualPhone(nextId, nameManualPhone, priceManualPhone, quantityManualPhone, producerManualPhone, nation, status);
            addPhone(manualPhone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeIdPhone(int phoneId) {
        boolean found = false;
        Iterator<Phone> iterator = phones.iterator();

        while (iterator.hasNext()) {
            Phone phone = iterator.next();

            if (phone.getId() == phoneId) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Are you sure you want to delete this phone? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    iterator.remove();
                    found = true;
                    System.out.println("Phone removed successfully.");
                    break;
                } else {
                    System.out.println("Removal canceled.");
                    return;
                }
            }
        }

        if (!found) {
            System.out.println("Phone with ID " + phoneId + " not found.");
        }

        writeFilePhone(phones);
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


