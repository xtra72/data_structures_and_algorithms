package com.nhnacademy.array;

public class Quiz17 {
    public static void main(String[] args) {
        int N = 1000;
        Primes.setSize(1000);
        int n = Primes.next();
        while (n < 0.9 * N) {
            if (Primes.isPrime(n + 2)) {
                System.out.println(n + "\t" + (n + 2));
            }
            n = Primes.next();
        }
    }
}