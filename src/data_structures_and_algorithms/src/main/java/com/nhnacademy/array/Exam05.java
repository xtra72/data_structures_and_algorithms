package com.nhnacademy.array;

public class Exam05 {

    public static void main(String[] args) {
        int[] a = { 22, 33, 44, 55, 66, 77, 88, 99 };
        Exam07.print("a", a);
        System.out.println("search(a, 44): " + search(a, 44));
        System.out.println("search(a, 50): " + search(a, 50));
        System.out.println("search(a, 77): " + search(a, 77));
        System.out.println("search(a, 100): " + search(a, 100));
    }

    public static int search(int[] s, int x) {
        int lo = 0;
        int hi = s.length;
        while (lo < hi) { // step 1
            int i = (lo + hi) / 2; // step 4
            if (s[i] == x) {
                return i; // step 5
            } else if (s[i] < x) {
                lo = i + 1; // step 6
            } else {
                hi = i; // step 7
            }
        }
        return -1; // step 2
    }
}