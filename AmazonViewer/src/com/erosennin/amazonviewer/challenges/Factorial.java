package com.erosennin.amazonviewer.challenges;

public class Factorial {

    public int iterative(int number) {
        int result = number;
        for (int i = number; 1 < i; i--) {
            result = result * (i - 1);
        }
        return result;
    }

    public int recursive(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * recursive(number - 1);
        }
    }
}
