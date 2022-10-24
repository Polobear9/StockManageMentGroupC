package Delete_System;

import GroupC.SystemUi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
this class can find the product info, use By ID. use a bufferedReader, for find the product info
and insert the info into the dataList. then output the product info to the command Line interface.

the user wants to delete the product info from the database(our database is SystemUi.FILEPATH File).
user most knows to delete the product ID from the database.
 */
public class DeleteById {
    private static String keyword;
    private static final ArrayList<String> arrayRepository = new ArrayList<>();
    private static final ArrayList<String> deleteRepository = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void search_By_Id(String keyword) {
        System.out.println("Search ByID");
        String test_Array;
        String[] testA;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(SystemUi.FILEPATH), "Shift_JIS"));
            int i = 0;
            while ((test_Array = br.readLine()) != null) {
                testA = test_Array.split(",");
                if (testA[0].equals(keyword)) {
                    deleteRepository.add(test_Array);
                    i++;
                    continue;
                }
                arrayRepository.add(test_Array);
            }
            System.out.println("-----Up List Data is be Delete-----");
            System.out.println("be Delete the data count : " + deleteRepository.size());
            System.out.println("After delete, All data count : " + arrayRepository.size());
            System.out.println("num : 1 = yes");
            String answer_Check = sc.nextLine();
            if (answer_Check.equals("1")) {
                delete_Check(br);
                arrayRepository.clear();
                deleteRepository.clear();
            } else {
                arrayRepository.clear();
                deleteRepository.clear();
            }
        } catch (Exception e) {

        }
    }

    private static void delete_Check(BufferedReader br) {
        try {
            br.close();
        } catch (IOException e) {
        }
        int i = 0;
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SystemUi.FILEPATH, false), "Shift_JIS"));
            while (i < arrayRepository.size()) {
                System.out.println(arrayRepository);
                bw.append(arrayRepository.get(i));
                bw.newLine();
                i++;
            }
            bw.close();
        } catch (Exception ex) {
        }
    }
}
