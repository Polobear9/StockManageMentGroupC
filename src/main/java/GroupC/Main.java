package GroupC;

import Delete_System.DeleteById;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keyword = sc.nextLine();
        DeleteById.serach_ById(keyword);
    }
}