package com.nhnacademy.sorting;

import java.util.Random;

public class Problem14_4 {
    public static void sort(int[] a) {
        int d = 1, j, n = a.length;
        while (9 * d < n) {
            d = 3 * d + 1;
        }
        while (d > 0) {
            for (int i = d; i < n; i++) {
                int ai = a[i];
                j = i;
                while (j >= d && a[j - d] > ai) {
                    a[j] = a[j - d];
                    j -= d;
                }
                a[j] = ai;
            }
            d /= 3;
        }
    }

    public static void main(String[] args) {
        int n = 200;
        int[] a = new int[200];

        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(n * 10);
        }

        Utils.print(a);
        sort(a);
        Utils.print(a);
    }

}
