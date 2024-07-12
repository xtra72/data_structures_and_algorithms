package com.nhnacademy.array;

import java.util.Arrays;

public class Exam13 {
    public static void main(String[] args) {
        int[] a = { 44, 77, 55, 22, 99, 88, 33, 66 };
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int k = Arrays.binarySearch(a, 44);
        System.out.printf("Arrays.binarySearch(a, 44): %d%n", k);
        System.out.printf("a[%d]: %d%n", k, a[k]);
        k = Arrays.binarySearch(a, 45);
        System.out.printf("Arrays.binarySearch(a, 45): %d%n", k);
        int[] b = new int[8];
        System.out.println(Arrays.toString(b));
        Arrays.fill(b, 55);
        System.out.println(Arrays.toString(b));
        System.out.println("Arrays.equals(a,b): " + Arrays.equals(a, b));
    }
}