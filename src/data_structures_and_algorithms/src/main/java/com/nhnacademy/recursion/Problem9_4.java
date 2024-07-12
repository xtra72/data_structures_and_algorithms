package com.nhnacademy.recursion;

public class Problem9_4 {
    public static int c(int n, int k) {
        if ((k == 0) || (n == k)) {
            return 1;
        }

        return c(n - 1, k - 1) + c(n - 1, k);
    }

    public static void main(String[] args) {
        for (int n = 0; n < 5; n++) {
            for (int k = 0; k <= n; k++) {
                int result = c(n, k);
                System.out.printf("%d ", result);
            }
            System.out.println("");
        }
    }
}
