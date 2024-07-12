package com.nhnacademy.array;

public class Quiz19 {

    public static void main(String[] args) {
        Primes.setSize(1000);
        System.out.println("4 = 2+2");
        for (int n = 6; n < 100; n += 2) {
            System.out.print(n);
            for (int p = 3; p <= n / 2; p += 2) {
                if (Primes.isPrime(p) && Primes.isPrime(n - p)) {
                    System.out.print(" = " + p + "+" + (n - p));
                }
            }
            System.out.println();
        }
    }
}