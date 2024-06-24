package example;

import java.util.Arrays;

public class TestSequentialSearch {
    public static void main(String[] args) {
        int[] a = { 22, 33, 44, 55, 66, 77, 88, 99 };
        System.out.println(Arrays.toString(a));
        System.out.println("search(a, 44): " + search(a, 44));
        System.out.println("search(a, 50): " + search(a, 50));
        System.out.println("search(a, 77): " + search(a, 77));
        System.out.println("search(a, 100): " + search(a, 100));
    }

    public static int search(int[] a, int x) {
        for (int i = 0; i < a.length; i++) { // step 1
            if (a[i] == x) { // step 3
                return i;
            }
        }
        return -1; // step 4
    }
}