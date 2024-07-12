package com.nhnacademy.linked_data_structures;

import java.util.Arrays;
import java.util.Random;

public class Exam01 {
    static void insert(int[] a, int n, int x) {
        int i = 0;

        while (i < n && a[i] <= x) {
            ++i;
        }

        System.arraycopy(a, i, a, i + 1, n - i);
        a[i] = x;
    }

    public static void main(String[] args) {
        int[] a = new int[10];

        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int x = random.nextInt(100);
            System.out.print(Arrays.toString(a) + " + " + x);
            insert(a, i, x);
            System.out.println(" = " + Arrays.toString(a));
        }
    }
}
