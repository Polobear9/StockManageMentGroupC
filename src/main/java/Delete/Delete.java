package Delete;

import Delete_System.DeleteById;

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
            select_DeleteMenu(sc);
        }
        menu_Status = true; // make a menu_status value --> true for next Time.
    }

    private static void select_DeleteMenu(Scanner sc) {
        switch (Menu(sc)) {
            case "1":
                System.out.println("1. Delete All DataBase");
                delete_AllData();
                break;
            case "2":
                System.out.println("2. Delete By ID");
                delete_ById();
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
        System.out.println("2. Delete By ID");
        System.out.println(" -------------------------------- ");
        return sc.nextLine();
    }

    private static void delete_AllData() {
        System.out.println("delete_AllData");
    }

    private static void delete_ById() {
        DeleteById.serach_ById();
    }
}
