package com.nhnacademy.recursion;

public class Example9_3 {
    public static int factorial(int n) {
        System.out.printf("called factorial(%d)%n", n);
        if (n == 0) {
            System.out.printf("return factorial(0) = 1%n", n);
            return 1;
        }

        int result = n * factorial(n - 1);
        System.out.printf("return factorial(%d) = %d * factorial(%d) = %d%n",
                n, n, n - 1, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.printf("factorial(%d) = %d%n", n, result);
    }
}
