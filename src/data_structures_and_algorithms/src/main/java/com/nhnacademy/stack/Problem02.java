package com.nhnacademy.stack;

public class Problem02 {
    interface Stack {
        void push(int data);

        int pop();

        int peek();

        int size();

        boolean isEmpty();
    }

    static class LinkedStack implements Stack {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this(data, null);
            }

            Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        Node top;

        public LinkedStack() {
            top = null;
        }

        public void push(int data) {
            top = new Node(data, top);
        }

        public int pop() {
            if (top == null) {
                throw new StackEmptyException();
            }

            int data = top.data;
            top = top.next;

            return data;
        }

        public int peek() {
            if (top == null) {
                throw new StackEmptyException();
            }

            return top.data;
        }

        public int size() {
            Node p = top;
            int count = 0;

            while (p != null) {
                count++;
                p = p.next;
            }

            return count;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Stack stack = new LinkedStack();

        stack.push(1);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(2);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(3);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(4);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(5);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
    }
}
