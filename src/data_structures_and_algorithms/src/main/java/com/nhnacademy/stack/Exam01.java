package com.nhnacademy.stack;

public class Exam01 {
    interface Stack {
        void push(int element);

        int pop();

        int peek();
    }

    static class ArrayStack {
        int top = -1;
        int[] array;

        ArrayStack(int size) {
            if (size < 0) {
                throw new IllegalArgumentException();
            }

            array = new int[size];
        }

        public int peek() {
            if (top < 0) {
                throw new StackEmptyException();
            }

            return array[top];
        }

        public void push(int element) {
            if (array.length <= top + 1) {
                throw new StackFullException();
            }

            array[++top] = element;
        }

        public int pop() {
            if (top < 0) {
                throw new StackEmptyException();
            }

            return array[top--];
        }
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(Integer.MAX_VALUE);

        stack.push(1);
        System.out.println("top : " + stack.peek());
        stack.push(2);
        System.out.println("top : " + stack.peek());
        stack.push(3);
        System.out.println("top : " + stack.peek());
        stack.push(4);
        System.out.println("top : " + stack.peek());
        stack.push(5);
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
    }
}
