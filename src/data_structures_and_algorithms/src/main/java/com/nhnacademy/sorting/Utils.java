package com.nhnacademy.sorting;

public class Utils {
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void print(int[] a) {
        for (int ai : a) {
            System.out.printf("%s ", ai);
        }
        System.out.println();
    }
}
