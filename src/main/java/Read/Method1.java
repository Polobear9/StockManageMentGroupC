package Read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Method1 {
    private static String[] list;

    private Method1() {
    }

    public static void searchMain() {
        while (true) {
            //キーワード入力
            System.out.println("商品情報を検索します。");
            System.out.println("検索キーワードを入力してください。");
            System.out.println("キーワード＞");
            Scanner sc = new Scanner(System.in);
            String keyword = sc.nextLine();

            String file = "/Users/harukiohta/Desktop/Myjava/test/test2.csv";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));//１行読み込み
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    list = line.split(",");
                    String id = list[0],
                            code = list[1],
                            name = list[2];
                    if (b(keyword, 0)) {
                        System.out.println(Arrays.toString(list));
                    } else if (b(keyword, 1)) {
                        System.out.println(Arrays.toString(list));
                    } else if (b(keyword, 2)) {
                        System.out.println(Arrays.toString(list));
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("続けて商品を検索しますか？");
            System.out.println("1:続けて検索する　2:メニューへ戻る　＞");
            String menuNumber = sc.nextLine();
            if (menuNumber.equals("1") || menuNumber.equals("１")) {
                continue;
            } else {
                break;
            }
        }

    }

    private static boolean b(String keyword, int i) {
        Pattern p = Pattern.compile(".{0,}" + keyword + ".{0,}");
        return p.matcher(list[i]).matches();
    }
}
