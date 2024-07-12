package com.nhnacademy.linked_data_structures;

import java.util.Random;

public class Problem02 {
    public static void insert(int[] a, int[] k, int free, int x) {
        int i = 0;
        while (k[i] != 0 && a[k[i]] < x) {
            i = k[i];
        }
        a[free] = x;
        k[free] = k[i];
        k[i] = free;
    }

    public static String toString(int[] a, int[] k) {
        StringBuilder builder = new StringBuilder();

        int next = 0;
        builder.append("[");
        if (k[0] != 0) {
            builder.append(String.format("%2d", a[k[0]]));
            next = k[0];
        }

        while (next != 0) {
            builder.append(String.format(", %2d", a[k[next]]));
            next = k[next];
        }
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[11];
        int[] k = new int[11];

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100);
            System.out.print(toString(a, k) + " + " + x);
            insert(a, k, i + 1, x);
            System.out.println(" = " + toString(a, k));
        }
    }
}
