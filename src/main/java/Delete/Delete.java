package Delete;

import java.util.Scanner;

public class Delete {
    public static void delete() {
    Scanner sc = new Scanner(System.in);
    int menuNumber = 0;

        while(true){
            menuNumber = Delete.Menu(sc);
            switch (menuNumber){
                case 1:
                    System.out.println("1. Delete All DataBase");
                    break;
                case 2:
                    System.out.println("2. Delete By ID");
                    break;
                case 3:
                    System.out.println("3. Delete By NAME");
                    break;
                case 4:
                    System.out.println("4. Delete By NUMBER");
                    break;
                default:
                    System.out.println("default");
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

}
