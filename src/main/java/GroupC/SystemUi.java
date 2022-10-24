package GroupC;

import Create.Register;
import Delete.Delete;
import Read.Method1;
import Update.FileChange;

import java.util.Scanner;

public class SystemUi {
    /*
    User a while statement, user can select the printDelete_Menu while the user do not select the printDelete_Menu number 0.
    @SuppressWarnings("InfiniteLoopStatement") --> select_printDelete_Menu(); method can make be while statement will stop.
    so No Matter while statement will infinite.
     */

    public static String FILEPATH = ".\\sampleData.csv";

    @SuppressWarnings("InfiniteLoopStatement")
    public static void start_System() {
        while (true) {
            System.out.println("メニュー番号を入力してください。");
            System.out.print("[メニュー] 1:検索 2:登録 3:変更 4:削除 0:終了 > ");
            select_printDelete_Menu();
        }
    }

    private static void select_printDelete_Menu() {
        /*
        Break sentence in switch statement make a return to start_System while statement.
        user can select the printDelete_Menu again when some printDelete_Menu was finished or user selected the To printDelete_Menu.
         */
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {// nextLine is Protect by Exception.
            case "1": //Search --> printDelete_Menu_Number == "1";
                System.out.println("---------------------------");
                System.out.println("検索メニューへ移動します。");
                System.out.println("---------------------------");
                Method1.searchMain();
                break;
            case "2": //Add --> printDelete_Menu_Number == "2";
                System.out.println("---------------------------");
                System.out.println("登録メニューへ移動します。");
                System.out.println("---------------------------");
                Register.register();
                break;
            case "3": //Change --> printDelete_Menu_Number == "3";
                System.out.println("---------------------------");
                System.out.println("変更メニューへ移動します。");
                System.out.println("---------------------------");
                FileChange fileChange = new FileChange(SystemUi.FILEPATH, "Shift_JIS");
                fileChange.change();
                break;
            case "4": //Delete --> printDelete_Menu_Number == "4";
                System.out.println("---------------------------");
                System.out.println("削除メニューへ移動します。");
                System.out.println("---------------------------");
                Delete.delete();
                break;
            case "0": //Exit --> printDelete_Menu_Number == "0";
                System.out.println("---------------------------");
                System.out.println("システムを終了します。");
                System.out.println("---------------------------");
                System.exit(0); // System be Stop No Matter while sentence.
                break;
            default:
                System.out.println("---------------------------");
                System.out.println("メニュー番号が間違っています。正しい値を入力してください。");
                System.out.println("---------------------------");

        }
    }
}
