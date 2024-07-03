package example.ch9;

public class Problem9_8 {

    public static void main(String[] args) {
        hanoiTowers(3, 'A', 'B', 'C');
    }

    public static void hanoiTowers(int n, char x, char y, char z) {
        if (n == 1) { // base part
            System.out.printf("Move top disk from peg %c to peg %c.%n", x, z);
        } else {
            hanoiTowers(n - 1, x, z, y); // recursion part
            hanoiTowers(1, x, y, z); // recursion part
            hanoiTowers(n - 1, y, x, z); // recursion part
        }
    }
}