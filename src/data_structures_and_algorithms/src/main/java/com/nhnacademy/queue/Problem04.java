package com.nhnacademy.queue;

import java.util.Arrays;

public class Problem04 {
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

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    static class LinkedQueue implements Queue {
        Node head;
        Node tail;

        public LinkedQueue() {
            tail = new Node(0);
            head = tail;
        }

        public int size() {
            Node p = head;
            int count = 0;

            while (p != tail) {
                count++;
                p = p.next;
            }

            return count;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        @Override
        public void enqueue(int element) {
            tail.setData(element);
            tail.setNext(new Node(0));

            tail = tail.getNext();
        }

        @Override
        public int peek() {
            if (head == tail) {
                throw new QueueEmptyException();
            }

            return head.getData();
        }

        @Override
        public int dequeue() {
            if (head == tail) {
                throw new QueueEmptyException();
            }

            Node firstNode = head;
            head = head.getNext();
            firstNode.setNext(null);

            return firstNode.getData();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("[");
            if (head != tail) {
                Node current = head;
                stringBuilder.append(String.format("%2d", current.getData()));
                current = current.getNext();
                while (current != tail) {
                    stringBuilder.append(String.format(", %2d", current.getData()));
                    current = current.getNext();
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        final int LOOP_COUNT = 100000;
        final int LOOP_COUNT2 = 1000000;
        CircularArrayQueue arrayQueue = new CircularArrayQueue(5);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayQueue.dequeue();
        }
        long finishedTime = System.currentTimeMillis();

        System.out.printf("Case 1%n");
        System.out.printf("CircularArrayQueue : %d loops = %d ms%n", LOOP_COUNT, finishedTime - startTime);

        LinkedQueue linkedQueue = new LinkedQueue();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedQueue.enqueue(i);
        }
        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedQueue.dequeue();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("LinkedQueue : %d loops = %d ms%n", LOOP_COUNT, finishedTime - startTime);

        CircularArrayQueue arrayQueue2 = new CircularArrayQueue(5);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT2; i++) {
            arrayQueue2.enqueue(i);
            arrayQueue2.dequeue();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("Case 2%n");
        System.out.printf("CircularArrayQueue : %d loops = %d ms%n", LOOP_COUNT2, finishedTime - startTime);

        LinkedQueue linkedQueue2 = new LinkedQueue();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT2; i++) {
            linkedQueue2.enqueue(i);
            linkedQueue2.dequeue();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("LinkedQueue : %d loops = %d ms%n", LOOP_COUNT2, finishedTime - startTime);
    }
}
