package example.ch6;

import java.util.Arrays;

public class ArrayQueue2 implements Queue {
    int[] array;
    int head;
    int tail;
    int expansionSize = 5;

    public ArrayQueue2(int size) {
        array = new int[size];
        head = 0;
        tail = 0;

    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getCapacity() {
        return array.length;
    }

    @Override
    public void add(int element) {
        if (array.length <= tail) {
            array = Arrays.copyOf(array, array.length + expansionSize);
        }

        array[tail++] = element;
    }

    @Override
    public int element() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        return array[head];
    }

    @Override
    public int remove() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        return array[head++];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        if (head != tail) {
            stringBuilder.append(String.format("%d", array[head]));

            for (int i = head + 1; i < tail; i++) {
                stringBuilder.append(String.format(", %d", array[i]));
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue2 queue = new ArrayQueue2(2);

        System.out.printf("%15s | %7s | %4s | %s%n",
                "Command", "isEmpty", "Size", "Elements");
        queue.add(1);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.add(1)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.add(2);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.add(2)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.add(3);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.add(3)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.add(4);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.add(4)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.add(5);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.add(5)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.remove();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.remove()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.remove();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.remove()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.remove();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.remove()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.remove();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.remove()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.remove();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.remove()",
                queue.isEmpty(), queue.size(), queue.toString());
    }
}
