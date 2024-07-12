package Menu;

import java.util.Scanner;

import manager.Manager;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void display(Manager manager) {
        try {
            while (true) {
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI");
                System.out.println("1. Thêm mới điện thoại");
                System.out.println("2. Xóa điện thoại");
                System.out.println("3. Xem danh sách điện thoại");
                System.out.println("4. Tìm kiếm điện thoại");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");

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
                        System.out.println("Kết thúc chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close(); // Đóng Scanner sau khi sử dụng
        }
    }

    private static void addTypePhone(Manager manager) {
        try {
            System.out.println("1. Thêm điện thoại Genuine");
            System.out.println("2. Thêm điện thoại Manual");
            System.out.print("Chọn loại điện thoại muốn thêm: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manager.addGenuinePhone(scanner);
                    break;
                case 2:
                    manager.addManualPhone(scanner);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private static void removePhone(Manager manager) {
        try {
            System.out.print("Nhập ID điện thoại cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            manager.removeIdPhone(id);
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private static void findPhone(Manager manager) {
        try {
            System.out.print("Nhập ID điện thoại cần tìm: ");
            int id = Integer.parseInt(scanner.nextLine());
            manager.findPhoneById(id);
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên.");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
