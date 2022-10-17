package Delete;

import java.util.Scanner;

public class Delete {
    public static void delete() {
        Scanner sc = new Scanner(System.in);
        int menuNumber;

        while (true) {
            menuNumber = Delete.Menu(sc);
            switch (menuNumber) {
                case 1:
                    System.out.println("1. Delete All DataBase");
                    delete_AllData();
                    break;
                case 2:
                    System.out.println("2. Delete By ID");
                    delete_ById();
                    break;
                case 3:
                    System.out.println("3. Delete By NAME");
                    delete_ByName();
                    break;
                case 4:
                    System.out.println("4. Delete By NUMBER");
                    delete_ByNumber();
                    break;
            }
            break;
        }

    }

    private static int Menu(Scanner sc) {
        System.out.println(" -------------------------------- ");
        System.out.println("Delete Menu");
        System.out.println("1. Delete All");
        System.out.println("2. Delete ID");
        System.out.println("3. Delete NAME");
        System.out.println("4. Delete NUMBER");
        System.out.println(" -------------------------------- ");
        return sc.nextInt();
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
