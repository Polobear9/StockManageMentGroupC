package Delete_System;

import java.io.*;
import java.util.Arrays;


/*
this class can find the product info, use By ID. use a bufferedReader, for find the product info
and insert the info into the dataList. then output the product info to the command Line interface.

the user wants to delete the product info from the database(our database is CSV File).
user most knows to delete the product ID from the database.
 */
public class DeleteById {
    private static String keyword;

    public static void serach_ById(String keyword) {
        System.out.println("something");
        String[] test_Array;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\c04.csv"), "Shift_JIS"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\lieam\\OneDrive\\문서\\test.csv"), "Shift_JIS"));
            while ((test_Array = br.readLine().split(",")) != null) {
                if (test_Array[0].equals(keyword)) {
                    System.out.println(Arrays.toString(test_Array));
                    bw.append(Arrays.toString(test_Array));
                    bw.newLine();
                }
            }
            br.close();
            bw.close();

        } catch (Exception e) {
        }
    }
}
