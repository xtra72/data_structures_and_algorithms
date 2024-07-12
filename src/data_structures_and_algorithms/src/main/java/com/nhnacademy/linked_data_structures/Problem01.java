package com.nhnacademy.linked_data_structures;

import java.util.Arrays;

public class Problem01 {
    static void arraycopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
        if ((src == null) || (dest == null)) {
            throw new NullPointerException();
        }

        if ((length < 0)
                || (srcPos < 0) || (src.length < srcPos + length)
                || (destPos < 0) || (dest.length < destPos + length)) {
            throw new IndexOutOfBoundsException();
        }

        if (srcPos < destPos) {
            for (int i = length - 1; i >= 0; i--) {
                dest[destPos + i] = src[srcPos + i];
            }
        } else if (destPos < srcPos) {
            for (int i = 0; i < length; i++) {
                dest[destPos + i] = src[srcPos + i];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] b = a.clone();

        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
        System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
        arraycopy(a, 1, a, 3, 5);
        System.arraycopy(b, 1, b, 3, 5);
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
        System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
        arraycopy(a, 4, a, 1, 5);
        System.arraycopy(b, 4, b, 1, 5);
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
        System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
    }
}