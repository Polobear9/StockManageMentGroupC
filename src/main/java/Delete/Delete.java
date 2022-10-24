package Delete;

import Delete_System.DeleteById;

import java.util.Scanner;

public class Delete {
    private static boolean printDelete_Menu_Status = true;

/*
    Insert ID and check data from SQLite or SystemUi.FILEPATH file.
    print out to CLI --> User need to check for delete the Data.
    If user select the Delete Data. the Data will be deleted.
    If user select the Cancel, Need call the Method for check Data info.
     */

    public static void delete() {
        while (printDelete_Menu_Status) {
            Scanner sc = new Scanner(System.in);
            printDelete_Menu();
            String delete_Keyword = sc.nextLine();
            delete_ById(delete_Keyword);
            printDelete_Menu_Status = choose_Continue();
        }
        printDelete_Menu_Status = true; // make a printDelete_Menu_status value --> true for next Time.
    }

    private static boolean choose_Continue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1:続けて削除する 2:メニューに戻る > ");
        String select = sc.nextLine();
        boolean judge = !select.equals("2");
        return judge;
    }

    private static void printDelete_Menu() {
        System.out.println(" -------------------------------- ");
        System.out.println("商品情報を削除します。");
        System.out.println("削除する商品IDを入力してください。");
        System.out.println(" -------------------------------- ");
    }

    private static void delete_ById(String delete_Keyword) {
        DeleteById.search_By_Id(delete_Keyword);
    }
}
