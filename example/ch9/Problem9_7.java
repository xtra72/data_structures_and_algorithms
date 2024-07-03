package example.ch9;

public class Problem9_7 {
    public static int gcd(int m, int n) {
        if (m == n) {
            return n;
        }

        if (m > n) {
            return gcd(m - n, n);
        } else {
            return gcd(m, n - m);
        }
    }

    public static void main(String[] args) {
        int m = 494;
        int n = 130;

        int result = gcd(m, n);

        System.out.printf("gcd(%d, %d) = %d%n", m, n, result);
    }
}
