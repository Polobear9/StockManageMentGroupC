

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Pattern;

import GroupC.SystemUi;

public class Register {

	//商品ID
	private static String productId;
	//商品コード
	private static String productCode;
	//商品名
	private static String productName;
	//商品分類
	private static String produCategory;
	//販売単価
	private static String sellingPrice;
	//仕入単価
	private static String purchasePrice;
	//登録日
	private static String registrationDate;

	private Register() {
	}

	public static void register() {
		Scanner sc = new Scanner(System.in);

		System.out.println("商品情報を登録します。");
		System.out.println("商品情報を入力してください。");
		A:
			while (true) {
				//商品ID登録
				productId(sc);
				//商品コード登録
				producCode(sc);
				//商品名登録
				productName(sc);
				//商品分類登録
				produCategory(sc);
				//販売単価登録
				sellingPrice(sc);
				//仕入れ単価登録
				purchasePrice(sc);
				//登録日登録
				registrationDate(sc);

				while (true) {
					System.out.print("登録しますか？ Y/N > ");
					String registerKey = sc.nextLine();
					close(registerKey);
					if (registerKey.equals("Y")) {
						String filename = SystemUi.FILEPATH;
						BufferedReader br = null;
						try {
							br = new BufferedReader(new FileReader(filename));
						} catch (FileNotFoundException e) {
							System.out.println(e.getMessage());
						}

						a:while (true) {
								BufferedWriter bw = null;
								try {
									while (true) {
										if (br.readLine() == null) {
											bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "Shift_JIS"));
											bw.append(productId + ","
													+ productCode + ","
													+ productName + ","
													+ produCategory + ","
													+ sellingPrice + ","
													+ purchasePrice + ","
													+ registrationDate);
											bw.newLine();
											bw.close();
											break a;
										}
									}
								} catch (IOException e) {
									System.out.println(e.getMessage());
								}
							}
						try {
							br.close();
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("商品を登録しました。");
						displayRegistrationInformation();
					} else if (registerKey.equals("N")) {
						System.out.println("商品登録をキャンセルしました。");
					} else {
						System.out.println("YかNで入力してください。");
						continue;
					}
					System.out.println("続けて商品を登録しますか？");
					System.out.print("1:続けて登録する 2:メニューへ戻る > ");
					String menuNumber = sc.nextLine();
					close(menuNumber);
					if (menuNumber.equals("1") || menuNumber.equals("１")) {
						continue A;
					} else {
						break A;
					}
				}
			}
	}

	private static void registrationDate(Scanner sc) {
		while (true) {
			System.out.print("登録日 > ");
			registrationDate = sc.nextLine();
			close(registrationDate);
			if (registrationDate.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (isRight("\\d{0,7}", registrationDate) || isRight("\\d{9,}", registrationDate)) {
				System.out.println("登録日は８桁の日付で入力してくだい。");
				continue;
			}
			if (!isRight("(\\d{4})(1[0-2]|0[1-9])(0[1-9]|[12][0-9]|3[01])", registrationDate)) {
				System.out.println("登録日は日付ではありません。８桁の日付で入力してください。");
				continue;
			}
			break;
		}
	}

	private static void purchasePrice(Scanner sc) {
		while (true) {
			System.out.print("仕入れ単価 > ");
			purchasePrice = sc.nextLine();
			close(purchasePrice);
			if (purchasePrice.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight("\\d{0,}", purchasePrice)) {
				System.out.println("販売単価は半角数字で入力してください。");
				continue;
			}
			if (!isRight("[\\d]{0,8}", purchasePrice)) {
				System.out.println("販売単価は８桁以下で入力してください。");
				continue;
			}
			break;
		}
	}

	private static void sellingPrice(Scanner sc) {
		while (true) {
			System.out.print("販売単価 > ");
			sellingPrice = sc.nextLine();
			close(sellingPrice);
			if (sellingPrice.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight("\\d{0,}", sellingPrice)) {
				System.out.println("販売単価は半角数字で入力してください。");
				continue;
			}
			if (!isRight("[\\d]{0,8}", sellingPrice)) {
				System.out.println("販売単価は８桁以下で入力してください。");
				continue;
			}
			break;
		}
	}

	private static void produCategory(Scanner sc) {
		while (true) {
			System.out.print("商品分類 > ");
			produCategory = sc.nextLine();
			close(produCategory);
			if (produCategory.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight(".+", produCategory)) {
				System.out.println("商品分類を入力してください。");
				continue;
			}
			try {
				if (produCategory.getBytes("Shift-JIS").length > 100) {
					System.out.println("商品分類は１００バイト（全角５０文字）以下で入力してください。");
					continue;
				}
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	private static void productName(Scanner sc) {
		while (true) {
			System.out.print("商品名 > ");
			productName = sc.nextLine();
			close(productName);
			if (productName.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight(".+", productName)) {
				System.out.println("商品名を入力してください。");
				continue;
			}
			try {
				if (productName.getBytes("Shift-JIS").length > 100) {
					System.out.println("商品名は１００バイト（全角５０文字）以下で入力してください。");
					continue;
				}
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	private static void producCode(Scanner sc) {
		while (true) {
			System.out.print("商品コード > ");
			productCode = sc.nextLine();
			close(productCode);
			if (productCode.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight("\\d{0,}", productCode)) {
				System.out.println("商品コードは半角数字で入力してください。");
				continue;
			}
			if (isRight("[\\d]{0,12}", productCode) || isRight("[\\d]{14,}", productCode)) {
				System.out.println("商品コードは13桁で入力してください。");
				continue;
			}
			if (isOverlap(productCode, 1)) {
				System.out.println("この商品コードはすでに使用されています。新しい商品コードを設定してください。");
				continue;
			}
			break;
		}
	}

	private static void productId(Scanner sc) {
		while (true) {
			System.out.print("商品ID > ");
			productId = sc.nextLine();
			close(productId);
			if (productId.contains(",")) {
				System.out.println("カンマは使用できません。");
				continue;
			}
			if (!isRight("[\\w-]{0,}", productId)) {
				System.out.println("商品IDは半角英数字・半角アンダースコア・半角ハイフンで入力してください");
				continue;
			}
			if (isRight("[\\w-]{0,9}", productId) || isRight("[\\w-]{11,}", productId)) {
				System.out.println("商品IDは１０桁で入力してください。");
				continue;
			}
			if (isOverlap(productId, 0)) {
				System.out.println("この商品IDはすでに使用されています。新しい商品IDを設定してください。");
				continue;
			}
			break;
		}
	}

	private static void displayRegistrationInformation() {
		System.out.println("商品ID = " + productId);
		System.out.println("商品コード = " + productCode);
		System.out.println("商品名 = " + productName);
		System.out.println("商品分類 = " + produCategory);
		System.out.println("販売単価 = " + sellingPrice);
		System.out.println("仕入単価 = " + purchasePrice);
		System.out.println("登録日 = " + registrationDate);
	}

	public static void close(String target) {
		if (target.equals("\\q") || target.equals("exit")) {
			System.out.println("プログラムを終了します");
			System.exit(0);
		}
	}

	private static boolean isOverlap(String target, int index) {
		
		String filename = SystemUi.FILEPATH;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			while (true) {
				String[] file = br.readLine().split(",");
				if (file[index].equals(target)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// --- refactory method ---

	private static boolean isRight(String regular, String target) {
		Pattern pattern = Pattern.compile(regular);
		return pattern.matcher(target).matches();
	}
}