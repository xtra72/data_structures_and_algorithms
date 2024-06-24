package example.ch6;

import java.util.Arrays;

public class ArrayQueue3 implements Queue {
    int[] array;
    int head;
    int tail;
    int expansionSize = 2;

    public ArrayQueue3(int size) {
        array = new int[size + 1];
        head = 0;
        tail = 0;

    }

    public int size() {
        return (array.length + tail - head) % array.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getCapacity() {
        return array.length - 1;
    }

    @Override
    public void add(int element) {
        if (size() == getCapacity()) {
            array = Arrays.copyOf(array, array.length + expansionSize);
        }

        array[tail] = element;
        tail = (tail + 1) % array.length;
    }

    @Override
    public int element() {
        if (size() == 0) {
            throw new QueueEmptyException();
        }

        return array[head];
    }

    @Override
    public int remove() {
        if (size() == 0) {
            throw new QueueEmptyException();
        }

        int value = array[head];
        head = (head + 1) % array.length;

        return value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        if (head != tail) {
            int ptr = head;
            stringBuilder.append(String.format("%2d", array[ptr]));
            ptr = (ptr + 1) % array.length;

            while (ptr != tail) {
                stringBuilder.append(String.format(", %2d", array[ptr]));
                ptr = (ptr + 1) % array.length;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue2 queue2 = new ArrayQueue2(2);
        ArrayQueue3 queue3 = new ArrayQueue3(2);

        for (int i = 0; i < 10; i++) {
            System.out.printf("queue2[%2d] : %5s - queue3[%2d] : %5s%n",
                    queue2.getCapacity(), queue2.toString(), queue3.getCapacity(), queue3.toString());
            queue2.add(i);
            queue3.add(i);
            System.out.printf("queue2[%2d] : %5s - queue3[%2d] : %5s%n",
                    queue2.getCapacity(), queue2.toString(), queue3.getCapacity(), queue3.toString());
            queue2.remove();
            queue3.remove();
        }
        System.out.printf("queue2[%2d] : %5s - queue3[%2d] : %5s%n",
                queue2.getCapacity(), queue2.toString(), queue3.getCapacity(), queue3.toString());
    }
}
