package Update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileChange {

	static String file_name;
	static String character_code;
	static List<Option> Selection = new ArrayList<Option>();
	static Scanner scanner = new Scanner(System.in);
	static String input;
	static StringBuilder sbFirst;
	static StringBuilder sbLast;
	static String strFirst;
	static String strLast;
	static String[] inputs_inFile = new String[7];
	static int selection_number;
	static int end_number;
	

	public FileChange(String file_name, String character_code) {
		FileChange.file_name = file_name;
		FileChange.character_code = character_code;
	}

	public void change() {

		Selection.add(Option.SHOHIN_ID);
		Selection.add(Option.SHOHIN_CODE);
		Selection.add(Option.SHOHIN_MEI);
		Selection.add(Option.SHOHIN_BUNRUI);
		Selection.add(Option.HANBAI_TANKA);
		Selection.add(Option.SHIIRE_TANKA);
		Selection.add(Option.TOROKUBI);
		Selection.add(Option.REGISTRATION);
		Selection.add(Option.CONTINUES);
		end_number = Selection.size();
		selection_number = 0;

		while (selection_number != end_number) {
			Selection.get(selection_number).input_check();
		}
		System.out.println("終了します。");
	}

	// @formatter:off
	public enum Option {
		CONTINUES("続行", 0) {
			@Override
			void input_check() {
				System.out.println("続けて商品を登録しますか？");
				System.out.print("1:続けて登録する 2:メニューへ戻る > ");
				input = scanner.nextLine();
				if (input.equals("1")) {
					selection_number = 0;
					return;
				} else if (input.equals("2")) {
					selection_number = end_number;
					return;
				} else {
					System.out.println("1か2を入力してください。");
					input_check();
					return;
				}
			}
		},
		REGISTRATION("登録", 0) {
			@Override
			void input_check() {
				System.out.print("商品情報を変更しますか？ Y/N > ");
				input = scanner.nextLine();
				if (back()) {return;}
				if (input.equals("Y")) {
					System.out.println("商品情報を登録しました。");
					for (int i = 0; i < inputs_inFile.length; i++) {
						System.out.println(Selection.get(i).getName() + " = " + inputs_inFile[i]);
					}
					writeFile();
					selection_number++;
					return;
				} else if (input.equals("N")) {
					selection_number++;
					return;
				} else {
					System.out.println("どちらか入力してください");
					input_check();
					return;
				}
			}
		},
		SHOHIN_ID("商品ID", 10) {
			@Override
			void input_check() {
				sbFirst = new StringBuilder();
				sbLast = new StringBuilder();
				String output = null;
				String searchID = null;
				
				System.out.println("変更する商品IDを入力してください。");
				System.out.print(getName() + " > ");

				try (BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(new FileInputStream(file_name), character_code))) {

					input = scanner.nextLine();
					if (back()) {selection_number = end_number;return;}
					if (byt_limit_check(getName(),getByt() )) {return;}

					while ((output = bufferedReader.readLine()) != null) {
						if (output.startsWith(input)) {
							searchID = input;
							inputs_inFile = output.split(",",-1);
							while ((output = bufferedReader.readLine()) != null) {
								sbLast.append(output).append("\n");
							}
							strFirst = sbFirst.toString();
							strLast = sbLast.toString();
							selection_number++;
							return;
						}
						sbFirst.append(output).append("\n");
					}

					if (searchID == null) {
						System.out.println("存在しない" + getName() + "です。" + getName() + "を確認してくだい。");
						input_check();
						return;
					}

				} catch (IOException e) {
					//catchする例外の親クラスは下に定義する
					System.out.println(e.getMessage());
				}
			}
		},
		SHOHIN_CODE("商品コード", 13) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(SHOHIN_CODE)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return ;}
				if(back()) {return ;}
				if (halfwidth_check(getName())) {input_check() ; return ;}
				if (byt_limit_check(getName(), getByt())) {input_check() ; return ;}
				if (code_check()) {input_check() ; return ;}
				try {
					inputs_inFile[Selection.indexOf(SHOHIN_CODE)] = input;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
					
				
				selection_number++;
			}
		},
		SHOHIN_MEI("商品名", 100) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(SHOHIN_MEI)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return ;}
				if(back()) {return ;}
				if (bytee_limit_check(getName(), getByt())) {input_check() ; return ;}
				inputs_inFile[Selection.indexOf(SHOHIN_MEI)] = input;
				selection_number++;
			}
		},
		SHOHIN_BUNRUI("商品分類", 100) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(SHOHIN_BUNRUI)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return ;}
				if(back()) {return ;}
				if (bytee_limit_check(getName(), getByt())) {input_check() ; return ;}
				inputs_inFile[Selection.indexOf(SHOHIN_BUNRUI)] = input;
				selection_number++;
			}
		},
		HANBAI_TANKA("販売単価", 8) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(HANBAI_TANKA)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return ;}
				if(back()) {return ;}
				if (halfwidth_check(getName())) {input_check() ; return ;}
				if (byt_up_limit_check(getName(), getByt())) {input_check() ; return ;}
				inputs_inFile[Selection.indexOf(HANBAI_TANKA)] = input;
				selection_number++;
			}
		},
		SHIIRE_TANKA("仕入単価", 8) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(SHIIRE_TANKA)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return ;}
				if(back()) {return ;}
				if (halfwidth_check(getName())) {input_check() ; return ;}
				if (byt_up_limit_check(getName(), getByt())) {input_check() ; return ;}
				inputs_inFile[Selection.indexOf(SHIIRE_TANKA)] = input;
				selection_number++;
			}
		},
		TOROKUBI("登録日", 8) {
			@Override
			void input_check() {
				System.out.print(getName() + "[" + inputs_inFile[Selection.indexOf(TOROKUBI)] + "] > ");
				input = scanner.nextLine();
				if (input.isEmpty()) {selection_number++; return;}
				if(back()) {return ;}
				if (halfwidth_check(getName())) {input_check(); return;}
				if (byt_limit_check(getName(), getByt())) {input_check(); return ;}
				if (date_check(getName())) {input_check(); return ;}
				inputs_inFile[Selection.indexOf(TOROKUBI)] = input;
				selection_number++;
			}
		};
// @formatter:on

		String name;
		int byt;
		abstract void input_check();
		
		private Option(String name, int byt) {
			this.name = name;
			this.byt = byt;
		}

		public String getName() {
			return name;
		}

		public int getByt() {
			return byt;
		}

		private static boolean halfwidth_check(String name) {
			if (!input.matches("\\d+")) {
				System.out.println(name + "は半角数字で入力してください。");
				return true;
			}
			return false;
		}

		private static boolean byt_limit_check(String name, int byt) {
			if (input.length() != byt) {
				System.out.println(name + "は" + byt + "桁で入力してください。");
				return true;
			}
			return false;
		}

		private static boolean byt_up_limit_check(String name, int byt) {
			if (input.length() > byt) {
				System.out.println(name + "は" + byt + "桁以下で入力してください。");
				return true;
			}
			return false;
		}

		private static boolean bytee_limit_check(String name, int byt) {
			try {
				if (input.getBytes("Shift_JIS").length > byt) {
					System.out.println(name + "は" + byt + "バイト（全角" + byt / 2 + "文字）以下で入力してください。");
					return true;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return false;
		}

		private static boolean date_check(String name) {
			try {
				DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT)
						.parse(input, LocalDate::from);
			} catch (DateTimeParseException e) {
				System.out.println(name + "は日付ではありません。８桁の日付で入力してくだい。");
				return true;
			}
			return false;
		}

		private static boolean code_check() {
			if (strFirst.contains(input) || strLast.contains(input)) {
				System.out.println("この商品コードはすでに使用されています。新しい商品コードを設定してください。");
				return true;
			}
			return false;
		}

		private static void writeFile() {
			try (BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file_name), character_code))) {
				bufferedWriter.write(strFirst + String.join(",", inputs_inFile) + "\n" + strLast);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private static boolean back() {
			if (input.equals("-")) {
				selection_number--;
				return true;
			}
			return false;
		}
	}
}