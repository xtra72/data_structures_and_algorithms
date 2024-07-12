package com.nhnacademy.queue;

import java.util.Arrays;

public class Problem02 {
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

    static class CircularArrayQueue implements Queue {
        int[] array;
        int head;
        int tail;
        int expansionSize = 2;

        public CircularArrayQueue(int size) {
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
        public void enqueue(int element) {
            if (size() == getCapacity()) {
                array = Arrays.copyOf(array, array.length + expansionSize);
            }

            array[tail] = element;
            tail = (tail + 1) % array.length;
        }

        @Override
        public int peek() {
            if (size() == 0) {
                throw new QueueEmptyException();
            }

            return array[head];
        }

        @Override
        public int dequeue() {
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
                stringBuilder.append(String.format("%d", array[ptr]));
                ptr = (ptr + 1) % array.length;

                while (ptr != tail) {
                    stringBuilder.append(String.format(", %d", array[ptr]));
                    ptr = (ptr + 1) % array.length;
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        CircularArrayQueue circularQueue = new CircularArrayQueue(2);

        System.out.printf("%10s | %10s | %10s | %10s | %10s | %10s%n",
                "queue", "Capacity", "Elements", "circularQueue", "Capacity", "Elements");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                    "queue", queue.getCapacity(), queue.toString(),
                    "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
            queue.enqueue(i);
            circularQueue.enqueue(i);
            System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                    "queue", queue.getCapacity(), queue.toString(),
                    "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
            queue.dequeue();
            circularQueue.dequeue();
        }
        System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                "queue", queue.getCapacity(), queue.toString(),
                "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
    }
}
