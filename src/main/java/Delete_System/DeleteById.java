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
    private static final ArrayList<String> saveDataRepository = new ArrayList<>(); //savaData will be saved in saveDataRepository
    private static final ArrayList<String> deleteDataRepository = new ArrayList<>(); //deleteData will  be saved in deleteDataRepository
    private static final Scanner sc = new Scanner(System.in);

    public static void search_By_Id(String delete_Keyword) {
        System.out.println("Search ByID");
        String csvLineData;
        String[] csvLineData_Array;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(SystemUi.FILEPATH), "Shift_JIS"));
            while ((csvLineData = br.readLine()) != null) {
                csvLineData_Array = csvLineData.split(",");
                if (csvLineData_Array[0].equals(delete_Keyword)) { // csvLineData_Array[0] is product ID, this line meaning (delete_Keyword == deleteTarget)
                    deleteDataRepository.add(csvLineData);// deleteTarget add into deleteDataRepository.
                    continue;
                }
                saveDataRepository.add(csvLineData); //Another data insert into saveDataRepository for Write in csv file.
            }
            select_DeleteTheData(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void csvLineData_Write(BufferedReader br) {
        try {
            br.close(); // BufferedReader will close for using a BufferedReader.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int i = 0;
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SystemUi.FILEPATH, false), "Shift_JIS"));
            while (i < saveDataRepository.size()) { // savaDataRepository.size() <-- without deleteData count.
                System.out.println(saveDataRepository.get(i)); // can see what of data will add in csv file.
                bw.append(saveDataRepository.get(i)); // bw.append() and bw.newLine() should add the saveData in csv file.
                bw.newLine();
                i++;
            }
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void select_DeleteTheData(BufferedReader br) {
        System.out.println("-----Up List Data is be Delete-----");
        System.out.println("be Delete the data count : " + deleteDataRepository.size());
        System.out.println("After delete, All data count : " + saveDataRepository.size());
        System.out.println("num : 1 = yes");
        String answer_Check = sc.nextLine();
        if (answer_Check.equals("1")) {
            csvLineData_Write(br);
            clearRepository();
        } else {
            clearRepository();
        }
    }

    private static void clearRepository() {
        saveDataRepository.clear();
        deleteDataRepository.clear();
    }
}
