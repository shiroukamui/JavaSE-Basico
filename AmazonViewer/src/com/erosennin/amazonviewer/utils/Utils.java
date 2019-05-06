package com.erosennin.amazonviewer.utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static boolean isNotNumber(String string) {
        boolean res = false;
        if (string.length()==0){
            res = true;
        }
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))){
                res = true;
                break;
            }
        }
        return res;
    }

    public static String validateUserResponseMenu(int size) {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (Utils.isNotNumber(option)) {
            System.out.println("\nThat option doesn't exist, please choose another.\n");
            option = "";
        } else if (Integer.parseInt(option) < 0 || size+2 < Integer.parseInt(option)) {
            System.out.println("\nThat option doesn't exist, please choose another.\n");
            option = "";
        }
        return option;
    }

    public static void timeDelay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
