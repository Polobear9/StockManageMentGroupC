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
    public static boolean isDataInIt = false;
    public static boolean keywordInputAgain = true;

    public static void search_By_Id(String delete_Keyword) {
        String csvLineData;
        String[] csvLineData_Array;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(SystemUi.FILEPATH), "Shift_JIS"));
            while ((csvLineData = br.readLine()) != null) {
                csvLineData_Array = csvLineData.split(",", -1);
                if (csvLineData_Array[0].equals(delete_Keyword)) { // csvLineData_Array[0] is product ID, this line meaning (delete_Keyword == deleteTarget)
                    deleteDataRepository.add(csvLineData);// deleteTarget add into deleteDataRepository.
                    continue;
                }
                saveDataRepository.add(csvLineData); //Another data insert into saveDataRepository for Write in csv file.
            }
            System.out.println("---------------------------");
            printDelete_Data();
            System.out.println("---------------------------");
            select_DeleteTheData(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printDelete_Data() {
        if (deleteDataRepository.size() == 0) {
            System.out.println("??????????????????????????????????????????????????????????????????????????????ID??????????????????????????????");
            isDataInIt = false;
            keywordInputAgain = true;
        }
        if (deleteDataRepository.size() >= 1) {
            int i = 0;
            isDataInIt = true;
            while (i < deleteDataRepository.size()) {
                keywordInputAgain = false;
                String[] deleteData_Info = deleteDataRepository.get(i).split(",", -1);
                int printInfo_Number = 0;
                a:
                while (true) {
                    switch (printInfo_Number) {
                        case 0:
                            System.out.println("??????ID = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 1:
                            System.out.println("??????????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 2:
                            System.out.println("????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 3:
                            System.out.println("???????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 4:
                            System.out.println("???????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 5:
                            System.out.println("???????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 6:
                            System.out.println("????????? = " + deleteData_Info[printInfo_Number]);
                            break;
                        case 7:
                            break a;
                    }
                    printInfo_Number++;
                }
                i++;
            }
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
        while (isDataInIt) {
            System.out.print("???????????????????????????????????? Y/N >");
            String answer_Check = sc.nextLine();
            if (answer_Check.equals("Y")) {
                csvLineData_Write(br);
                System.out.println("??????????????????????????????");
                break;
            } else if (answer_Check.equals("N")) {
                System.out.println("?????????????????????????????????????????????");
                break;
            } else {
                System.out.println("???????????????????????????????????????");
            }
        }
        clearRepository();
    }

    private static void clearRepository() {
        saveDataRepository.clear();
        deleteDataRepository.clear();
    }
}
