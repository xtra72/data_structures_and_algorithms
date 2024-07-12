package com.nhnacademy.queue;

public interface Queue {
    public void enqueue(int element);

    public int dequeue();

    public int peek();
}
