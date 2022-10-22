package Delete_System;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


/*
this class can find the product info, use By ID. use a bufferedReader, for find the product info
and insert the info into the dataList. then output the product info to the command Line interface.

the user wants to delete the product info from the database(our database is CSV File).
user most knows to delete the product ID from the database.
 */
public class DeleteById {
    public static void serach_ById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("something");
        String test;
        String[] test_Array;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\c03.csv"), "UTF-8"));
            while((test_Array = br.readLine().split(",")) != null){
                if(test_Array[0].equals("47")){
                    System.out.println(Arrays.toString(test_Array));
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
