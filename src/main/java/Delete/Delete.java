package Delete;

import Delete_System.DeleteById;
import Delete_System.Delete_All;

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
            Menu();
            delete_ById();
            break;
        }
        menu_Status = true; // make a menu_status value --> true for next Time.
    }

    private static void Menu() {
        System.out.println(" -------------------------------- ");
        System.out.println("Delete Menu");
        System.out.println(" -------------------------------- ");
    }

    private static void delete_ById() {
        DeleteById.serach_ById();
    }
}
