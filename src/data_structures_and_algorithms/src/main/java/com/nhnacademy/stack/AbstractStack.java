package com.nhnacademy.stack;

public abstract class AbstractStack<E> implements Stack<E> {
    protected int size;

    public abstract void push(E element);

    public abstract E pop();

    public abstract E peek();

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }
}