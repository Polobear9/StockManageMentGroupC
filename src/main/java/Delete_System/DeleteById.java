package Delete_System;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
this class can find the product info, use By ID. use a bufferedReader, for find the product info
and insert the info into the dataList. then output the product info to the command Line interface.

the user wants to delete the product info from the database(our database is CSV File).
user most knows to delete the product ID from the database.
 */
public class DeleteById {
    private static String keyword;
    static ArrayList<String> arrayRepository = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void search_By_Id(String keyword) {
        System.out.println("Search ByID");
        String test_Array;
        String[] testA;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\lieam\\OneDrive\\바탕 화면\\Input.csv"), "Shift_JIS"));
            int i = 0;
            while ((test_Array = br.readLine()) != null) {
                testA = test_Array.split(",");
                if (testA[0].equals(keyword)) {
                    arrayRepository.add(test_Array);
                    System.out.println(arrayRepository.get(i));
                    i++;
                }
            }
            System.out.println("Delete?");
            System.out.print(arrayRepository.size());
            String answer_Check = sc.nextLine();
            if (answer_Check.equals("1")) {
                delete_Check(br);
            }
        } catch (Exception e) {
        }
    }

    private static void delete_Check(BufferedReader br) {
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int i = 0;
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\lieam\\OneDrive\\바탕 화면\\Input.csv", false), "Shift_JIS"));
            while (i < arrayRepository.size()) {
                System.out.println(arrayRepository);
                bw.append(arrayRepository.get(i));
                bw.newLine();
                i++;
            }
            bw.close();
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
