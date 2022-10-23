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
            Menu();
            String keyword = sc.nextLine();
            delete_ById(keyword);
            menu_Status = choose();
        }
        menu_Status = true; // make a menu_status value --> true for next Time.
    }

    private static boolean choose() {
        Scanner sc = new Scanner(System.in);
        System.out.println("continue??");
        String select = sc.nextLine();
        boolean judge = true;
        if(select.equals("1")){
            judge = true;
        }
        if(select.equals("2")){
            judge = false;
        }
        return judge;
    }

    private static void Menu() {
        System.out.println(" -------------------------------- ");
        System.out.println("Delete Menu");
        System.out.println("Please enter the Keyword for search");
        System.out.println(" -------------------------------- ");
    }

    private static void delete_ById(String keyword) {
        DeleteById.search_By_Id(keyword);
    }
}
