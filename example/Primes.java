package example;

import java.util.BitSet;

public class Primes {
    private static final int SIZE = 1000;
    private static int size = SIZE;
    private static BitSet sieve = new BitSet(size);
    private static int last = 1;

    static {
        for (int i = 2; i < SIZE; i++) {
            sieve.set(i);
        }
        for (int n = 2; 2 * n < SIZE; n++) {
            if (sieve.get(n)) {
                for (int m = n; m * n < SIZE; m++) {
                    sieve.clear(m * n);
                }
            }
        }
    }

    public static void setLast(int n) {
        last = n;
    }

    public static void setLast() {
        last = 1;
    }

    public static void setSize(int n) {
        size = n;
    }

    public static void setSize() {
        size = 1000;
    }

    public static boolean isPrime(int n) {
        return sieve.get(n);
    }

    public static int next() {
        while (++last < size) {
            if (sieve.get(last)) {
                return last;
            }
        }
        return -1;
    }

    public static void printPrimes() {
        int n = 0;
        for (int i = 0; i < SIZE; i++) {
            if (sieve.get(i)) {
                System.out.print((n++ % 10 == 0 ? "\n" : "\t") + i);
            }
        }
        System.out.println("\n" + n + " primes less than " + SIZE);
    }
}