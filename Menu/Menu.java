package Menu;

import java.util.Scanner;

import manager.Manager;
import org.w3c.dom.ls.LSOutput;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public void display(Manager manager) {
        try {
            while (true) {
                System.out.println("PHONE MANAGEMENT PROGRAM");
                System.out.println("1. Add new phone");
                System.out.println("2. Erase phone");
                System.out.println("3. Show phone list");
                System.out.println("4. Search for phone");
                System.out.println("5. Exit");
                System.out.print("Select function:");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addTypePhone(manager);
                        break;
                    case 2:
                        removePhone(manager);
                        break;
                    case 3:
                        manager.displayPhone();
                        break;
                    case 4:
                        findPhone(manager);
                        break;
                    case 5:
                        System.out.println("End program.");
                        return;
                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Please enter number.");
        } catch (Exception e) {
            System.out.println("Error! An error occurred. Please try again later:" + e.getMessage());
        } finally {
            scanner.close(); // Đóng Scanner sau khi sử dụng
        }
    }

    private static void addTypePhone(Manager manager) {
        try {
            System.out.println("1.Add Genuin phonee");
            System.out.println("2. Add Manual phone");
            System.out.print("Select the type of phone you want to add: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manager.addGenuinePhone(scanner);
                    break;
                case 2:
                    manager.addManualPhone(scanner);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Please enter number.");
        } catch (Exception e) {
            System.out.println("Error! An error occurred. Please try again later: " + e.getMessage());
        }
    }

    private static void removePhone(Manager manager) {
        try {
            System.out.print("Enter the phone ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            manager.removeIdPhone(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter an integer.");
        } catch (Exception e) {
            System.out.println("Error! An error occurred. Please try again later: " + e.getMessage());
        }
    }

    private static void findPhone(Manager manager) {
        try {
            System.out.print("Enter the phone ID you want to find: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println(manager.findPhoneById(id));
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter an integer.");
        } catch (Exception e) {
            System.out.println("Error! An error occurred. Please try again later: "+ e.getMessage());
        }
    }
}
