package com.nhnacademy.sorting;

import java.util.Random;

public class Problem14_2 {
    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) { // step 1
            int m = 0;
            for (int j = 1; j <= i; j++) { // step 2
                if (a[j] > a[m]) {
                    m = j;
                }
            }

            Utils.swap(a, i, m); // step 3
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
