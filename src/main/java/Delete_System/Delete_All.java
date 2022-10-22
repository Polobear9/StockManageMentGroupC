package Delete_System;

import java.io.*;
import java.util.Arrays;

public class Delete_All {
    public static void readAndDelete() {
        System.out.println("something");
        String[] test_Array;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\c04.csv"), "Shift_JIS"));
            while ((test_Array = br.readLine().split(",")) != null) {
                System.out.println(Arrays.toString(test_Array));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}