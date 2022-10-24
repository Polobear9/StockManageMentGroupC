package GroupC;

import Create.Register;
import Delete.Delete;
import Read.Method1;
import Update.FileChange;

import java.util.Scanner;

public class SystemUi {
    /*
    User a while statement, user can select the menu while the user do not select the menu number 0.
    @SuppressWarnings("InfiniteLoopStatement") --> select_Menu(); method can make be while statement will stop.
    so No Matter while statement will infinite.
     */

    public static String FILEPATH = ".\\sampleData.csv";

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start_System() {
        while (true) {
            System.out.println("Please Select the Menu");
            System.out.println("1. Search , 2. Add , 3. Change , 4. Delete, 0. System stop.");
            select_Menu();
        }
    }

    private static void select_Menu() {
        /*
        Break sentence in switch statement make a return to start_System while statement.
        user can select the menu again when some menu was finished or user selected the To Menu.
         */
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {// nextLine is Protect by Exception.
            case "1": //Search --> menu_Number == "1";
                System.out.println("Search Menu");
                Method1.searchMain();
                break;
            case "2": //Add --> menu_Number == "2";
                System.out.println("Add Menu");
                Register.register();
                break;
            case "3": //Change --> menu_Number == "3";
                System.out.println("Change Menu");
                FileChange fileChange = new FileChange(SystemUi.FILEPATH, "Shift_JIS");
                fileChange.change();
                break;
            case "4": //Delete --> menu_Number == "4";
                System.out.println("Delete Menu");
                Delete.delete();
                break;
            case "0": //Exit --> menu_Number == "0";
                System.out.println("System Shutdown");
                System.exit(0); // System be Stop No Matter while sentence.
                break;
            default:
                System.out.println("Please enter the number (1 ~ 4 or 0)");

        }
    }
}
