package example.ch5;

import java.util.Arrays;

interface Stack {
    public void push(int element);

    public int peek();

    public int pop();

    public int size();

    public boolean isEmpty();
}

class ArrayStack implements Stack {
    static final int DEFAULT_EXPANSION_SIZE = 10;
    int expansionSize = 10;
    int top = -1;
    int[] array;

    ArrayStack(int size) {
        this(size, DEFAULT_EXPANSION_SIZE);
    }

    ArrayStack(int size, int expansionSize) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        array = new int[size];
        this.expansionSize = expansionSize;
    }

    public int peek() {
        if (top < 0) {
            throw new StackEmptyException();
        }

        return array[top];
    }

    public void push(int element) {
        if (array.length <= top + 1) {
            array = Arrays.copyOf(array, array.length + expansionSize);
        }

        array[++top] = element;
    }

    public int pop() {
        if (top < 0) {
            throw new StackEmptyException();
        }

        return array[top--];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }
}

public class Problem5_1 {
    public static void main(String[] args) {
        Stack stack = new ArrayStack(3, 1);

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
