package Delete;

import java.util.Scanner;

public class Delete {
    private static boolean menu_Status = true;

/*
    Insert ID and check data from SQLite or CSV file.
    print out to CLI --> User need to check for delete the Data.
    If user select the Delete Data. the Data will be deleted.
    If user select the Cancel, Need call the Method for check Data info.
     */

    public static void delete() {
        while (menu_Status) {
            Scanner sc = new Scanner(System.in);
            select_DeleteMenu(Menu(sc));
        }
        menu_Status = true;
    }

    private static void select_DeleteMenu(String menuNumber) {
        switch (menuNumber) {
            case "1":
                System.out.println("1. Delete All DataBase");
                delete_AllData();
                break;
            case "2":
                System.out.println("2. Delete By ID");
                delete_ById();
                break;
            case "3":
                System.out.println("3. Delete By NAME");
                delete_ByName();
                break;
            case "4":
                System.out.println("4. Delete By NUMBER");
                delete_ByNumber();
                break;
            case "0":
                menu_Status = false;
                break;
        }
    }

    private static String Menu(Scanner sc) {
        System.out.println(" -------------------------------- ");
        System.out.println("Delete Menu");
        System.out.println("1. Delete All");
        System.out.println("2. Delete ID");
        System.out.println("3. Delete NAME");
        System.out.println("4. Delete NUMBER");
        System.out.println("0. Delete Menu Finish");
        System.out.println(" -------------------------------- ");
        return sc.nextLine();
    }

    private static void delete_AllData() {
        System.out.println("delete_AllData");
    }

    private static void delete_ById() {
        System.out.println("delete_ById");
    }

    private static void delete_ByName() {
        System.out.println("delete_ByName");
    }

    private static void delete_ByNumber() {
        System.out.println("delete_ByNumber");
    }
}
