package example;

import java.util.Arrays;

public class PascalTriangle {
    static int[][] pascal(int n) {
        int[][] p = new int[n][];
        for (int j = 0; j < n; j++) {
            p[j] = new int[j + 1];
            p[j][0] = p[j][j] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[][] p = pascal(10);

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(p[i]));
        }
    }
}
