package com.nhnacademy.sorting;

import java.util.Random;

public class Problem14_6 {
    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }

    private static void sort(int[] a, int p, int q) {
        if (q - p < 2) {
            return;
        }
        int m = (p + q) / 2;
        sort(a, p, m);
        sort(a, m, q);
        merge(a, p, m, q);
    }

    private static void merge(int[] a, int p, int m, int q) {
        if (a[m - 1] <= a[m]) {
            return;
        }

        int i = p, j = m, k = 0;
        int[] tmp = new int[q - p];
        while (i < m && j < q) {
            tmp[k++] = (a)[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i < m) {
            tmp[k++] = a[i++];
        }

        while (j < p) {
            tmp[k++] = a[j++];
        }

        System.arraycopy(tmp, 0, a, p, k);
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
