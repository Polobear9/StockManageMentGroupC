package GroupC;

import java.util.Scanner;

public class SystemUi {
    public static void start_System(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select the Menu");
        System.out.println("[メニュー] 1:検索 2:登録 3:変更 4:削除 0:終了>");
        scanner.nextLine();

    }
}
