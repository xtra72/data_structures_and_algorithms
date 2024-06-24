package example;

import java.util.Random;

class Node {
    int data;
    int next;
}

public class Problem3_3 {

    public static void insert(Node[] a, int x) {
        int i = 0;
        int free = 1;
        for (; free < a.length; free++) {
            if (a[free] == null) {
                break;
            }
        }

        if (free == a.length) {
            // full
            return;
        }

        int last = 0;
        while (a[last].next > 0) {
            last = a[last].next;
        }

        a[last].next = free;
        a[free] = new Node();
        a[free].data = x;
        a[free].next = 0;
    }

    public static String toString(Node[] a) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        int next = a[0].next;
        if (next != 0) {
            builder.append(String.format("%2d", a[next].data));
            next = a[next].next;
        }

        while (next != 0) {
            builder.append(String.format(", %2d", a[next].data));
            next = a[next].next;
        }
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        Node[] a = new Node[10];

        a[0] = new Node();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100);
            System.out.print(toString(a) + " + " + x);
            insert(a, x);
            System.out.println(" = " + toString(a));
        }
    }
}
