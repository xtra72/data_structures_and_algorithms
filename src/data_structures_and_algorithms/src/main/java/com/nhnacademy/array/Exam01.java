package com.nhnacademy.array;

import java.util.Arrays;

public class Exam01 {
    public static void main(String[] args) {
        float x[];
        x = new float[10];
        args = new String[10];
        boolean[] isPrime = new boolean[5];
        int fib1[] = { 0, 1, 1, 2, 3, 5, 8, 13 };
        int fib2[] = new int[] { 0, 1, 1, 2, 3, 5, 8, 13 };
        double a[][] = { { 1.1, 2.2 }, { 3.3, 4.4 }, null, { 5.5, 6.6 }, null };
        short[][] b = new short[4][10];
        Object[] objects = { x, args, isPrime, fib1, fib2, b, a };
        Integer[] ints = {};

        System.out.println("x = " + Arrays.toString(x));
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("isPrime = " + Arrays.toString(isPrime));
        System.out.println("fib1 = " + Arrays.toString(fib1));
        System.out.println("fib2 = " + Arrays.toString(fib2));
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("objects instanceof Object[] = " + (objects instanceof Object[]));
        System.out.println("objects[0] instanceof Object = " + (objects[0] instanceof Object));
        System.out.println("objects[0] instanceof float[] = " + (objects[0] instanceof int[]));
        System.out.println("b[0] instanceof short[] = " + (b[0] instanceof short[]));
        System.out.println("ints instanceof Object = " + (ints instanceof Object));
        System.out.println("ints instanceof Object[] = " + (ints instanceof Object[]));
    }
}
