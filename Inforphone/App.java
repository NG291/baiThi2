package Inforphone;

import manager.Manager;
import  Menu.Menu;
public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Manager manager = new Manager();
        menu.display( manager);
    }
}
