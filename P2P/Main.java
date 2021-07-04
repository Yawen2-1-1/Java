package P2P;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        /* 登入前的功能選單 */
        System.out.print("功能表：\n" + "1. 登入\t" + "2. 註冊\n選擇功能：");

        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                String account;
                String password;

                System.out.print("帳號： ");
                account = scanner.next();
                System.out.print("密碼： ");
                password = scanner.next();

                Login login = new Login(account, password);
                if (login.IfLogin()) {
                    // 顯示登入後的功能選單
                    DBGetName dbGetName = new DBGetName();
                    System.out.println("\n歡迎 " + dbGetName.getName(account) + " , 這裡是功能選單：");
                    menu.printMenu(account);
                }
            } else if (choice == 2) {
                /* 選擇 2. 註冊 */
                String name;
                String contact;
                String account;
                String password;

                System.out.print("姓名： ");
                name = scanner.next();
                System.out.print("聯絡方式(郵件位址或電話號碼)： ");
                contact = scanner.next();
                System.out.print("帳號： ");
                account = scanner.next();
                System.out.print("密碼： ");
                password = scanner.next();

                Register register = new Register(account, password, name, contact);

                if (register.IfRegister()) {
                    // 顯示登入後的功能選單
                    System.out.println("\n歡迎 " + register.getName() + " ,這裡是功能選單：");
                    menu.printMenu(account);
                }
            } else {
                System.out.println("指令錯誤：功能尚未開啟");
            }
        } catch (InputMismatchException e) {
            System.out.println("輸入錯誤：選擇功能只接受整數");
        }
    }
}
