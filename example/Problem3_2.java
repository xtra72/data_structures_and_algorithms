package example;

import java.util.Arrays;
import java.util.Random;

public class Problem3_2 {
    int[] a = new int[10];
    int[] k = new int[10];
    int free = 1;

    public void insert(int x) {
        if (free == k.length) {
            a = Arrays.copyOf(a, a.length + 10);
            k = Arrays.copyOf(k, k.length + 10);
        }

        int i = 0;
        while (k[i] != 0 && a[k[i]] < x) {
            i = k[i];
        }
        a[free] = x;
        k[free] = k[i];
        k[i] = free++;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        int next = k[0];
        if (next != 0) {
            builder.append(String.format("%2d", a[next]));
            next = k[next];
        }

        while (next != 0) {
            builder.append(String.format(", %2d", a[next]));
            next = k[next];
        }
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        IndexedArray a = new IndexedArray(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100);
            System.out.print(a + " + " + x);
            a.insert(x);
            System.out.println(" = " + a);
        }
    }
}
