package com.nhnacademy.array;

public class Exam06 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5 };

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        for (int value : a) {
            System.out.println(value);
        }
    }
}
