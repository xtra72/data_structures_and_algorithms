package com.nhnacademy.sorting;

import java.util.Random;

public class Problem14_3 {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int ai = a[i];
            for (j = i; j > 0 && a[j - 1] > ai; j--) {
                a[j] = a[j - 1];
            }
            a[j] = ai;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];

        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }

        Utils.print(a);
        sort(a);
        Utils.print(a);
    }
}
