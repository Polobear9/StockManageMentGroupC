import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Method1 {
	private static String[] list;
	private Method1() {}
	public static void searchMain() {
		while(true) {
			//キーワード入力
			System.out.println("商品情報を検索します。");
			System.out.println("検索キーワードを入力してください。");
			System.out.println("キーワード＞");
			Scanner sc = new Scanner(System.in);
			String keyword = sc.nextLine();

			String file = "/Users/harukiohta/Desktop/Myjava/test/test2.csv";
			//String fileはFileReaderの引数
			try  { 
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));//１行読み込み
				
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					list = line.split(",",-1); 
					//第２引数に「-1」を入れるとnull（何もない要素）でも「,(空白),」で表示される
					String id = list[0],
							code = list[1],
							name = list[2];
					//keywordと配列の要素を比較して真の場合、listを表示する
					if (b(keyword, 0)) {
						//if文の条件式は最下部のboolean型bメソッド
						System.out.println(Arrays.toString(list));
					}else if (b(keyword, 1)) {
						System.out.println(Arrays.toString(list));
					}else if (b(keyword, 2)) {
						System.out.println(Arrays.toString(list));
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("続けて商品を検索しますか？");
			System.out.println("1:続けて検索する　2:メニューへ戻る　＞");
			String menuNumber = sc.nextLine();
			//menuNumberの入力時、全角半角を区別しない。
			if (menuNumber.equals("1") || menuNumber.equals("１")) {
				continue;
			} else {
				break;
			}
		}
	}
	//キーワードの前後の文字列は考慮しない
	//正規表現
	private static boolean b(String keyword,int i) {
		Pattern p = Pattern.compile(".{0,}" + keyword + ".{0,}");
		return p.matcher(list[i]).matches();
	}  
}
