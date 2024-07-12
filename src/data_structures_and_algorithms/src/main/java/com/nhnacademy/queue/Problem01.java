package com.nhnacademy.queue;

import java.util.Arrays;

public class Problem01 {

    static class ArrayQueue implements Queue {
        int[] array;
        int head;
        int tail;
        int expansionSize = 5;

        public ArrayQueue(int size) {
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
        public void enqueue(int element) {
            if (array.length <= tail) {
                array = Arrays.copyOf(array, array.length + expansionSize);
            }

            array[tail++] = element;
        }

        @Override
        public int peek() {
            if (head == tail) {
                throw new QueueEmptyException();
            }

            return array[head];
        }

        @Override
        public int dequeue() {
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

    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);

        System.out.printf("%15s | %7s | %4s | %s%n",
                "Command", "isEmpty", "Size", "Elements");
        queue.enqueue(1);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(1)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(2);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(2)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(3);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(3)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(4);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(4)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(5);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(5)",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
                queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
                queue.isEmpty(), queue.size(), queue.toString());
    }
}
