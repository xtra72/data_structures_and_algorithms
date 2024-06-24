package example;

import java.util.Random;

public class Example3_2 {
    static int[] a = new int[10];
    static int[] k = new int[10];
    static int length = 0;
    static int free = 1;

    public static void insert(int x) {
        int i = 0;
        while (i < k.length && k[i] != 0 && a[k[i]] < x) {
            i++;
        }

        if (free < a.length && i < k.length) {
            System.arraycopy(k, i, k, i + 1, length - i);
            a[free] = x;
            k[i] = free++;
            length++;
        }
    }

    public static String toString(int[] a, int[] k, int length) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        if (length > 0) {
            builder.append(String.format("%3d", a[k[0]]));
        }

        for (int i = 1; i < length; i++) {
            builder.append(String.format(", %3d", a[k[i]]));
        }
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100);
            System.out.print(toString(a, k, length) + " + " + x);
            insert(x);
            System.out.println(" = " + toString(a, k, length));
        }
    }
}
