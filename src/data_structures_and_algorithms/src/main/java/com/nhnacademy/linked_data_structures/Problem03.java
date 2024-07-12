package com.nhnacademy.linked_data_structures;

public class Problem03 {
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
    }

    static void insert(Node start, int x) {
        // PRECONDITIONS: the list is in ascending order, and x > start.data;
        // POSTCONDITIONS: the list is in ascending order, and it contains x;
        Node p = start;
        while (p.next != null) {
            if (p.next.data > x)
                break;
            p = p.next;
        }
        p.next = new Node(x, p.next);
    }

    static void println(Node start) {
        System.out.print("[");
        Node p = start;
        System.out.print(String.format("%2d", p.data));
        p = p.next;
        while (p != null) {
            System.out.print(String.format(", %2d", p.data));
            p = p.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] datas = { 22, 55, 44, 66, 33 };

        Node start = new Node(datas[0]);
        println(start);

        for (int i = 1; i < 5; i++) {
            insert(start, datas[i]);
            println(start);
        }
    }
}
