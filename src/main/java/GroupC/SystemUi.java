package GroupC;

import Delete.Delete;

import java.util.Scanner;

public class SystemUi {
    /*
    User a while statement, user can select the menu while the user do not select the menu number 0.
    @SuppressWarnings("InfiniteLoopStatement") --> select_Menu(); method can make be while statement will stop.
    so No Matter while statement will infinite.
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void start_System() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Select the Menu");
            System.out.println("test");
            String menu_Number = scanner.nextLine(); // nextLine is Protect by Exception.
            select_Menu(menu_Number);
        }
    }

    private static void select_Menu(String menu_Number) {
        /*
        Break sentence in switch statement make a return to start_System while statement.
        user can select the menu again when some menu was finished or user selected the To Menu.
         */
        switch (menu_Number) {
            case "1": //Search --> menu_Number == "1";
                System.out.println("Search Menu");
                break;
            case "2": //Add --> menu_Number == "2";
                System.out.println("Add Menu");
                /*Register.register();*/
                break;
            case "3": //Change --> menu_Number == "3";
                System.out.println("Change Menu");

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
