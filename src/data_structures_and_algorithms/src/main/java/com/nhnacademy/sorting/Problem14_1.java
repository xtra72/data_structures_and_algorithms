package com.nhnacademy.sorting;

import java.util.Random;

public class Problem14_1 {
    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) { // step 1
            for (int j = 0; j < i; j++) { // step 2
                if (a[j] > a[j + 1]) {
                    Utils.swap(a, j, j + 1); // step 3
                }
            }
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
