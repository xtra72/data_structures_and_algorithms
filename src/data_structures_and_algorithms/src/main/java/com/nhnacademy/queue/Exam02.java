package com.nhnacademy.queue;

public class Exam02 {
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
            head = new Node(0);
            tail = head;
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
        Queue queue = new LinkedQueue();

        System.out.println("queue : " + queue);
        queue.enqueue(1);
        System.out.println("queue : " + queue);
        queue.enqueue(2);
        System.out.println("queue : " + queue);
        queue.enqueue(3);
        System.out.println("queue : " + queue);
        queue.enqueue(4);
        System.out.println("queue : " + queue);
        queue.enqueue(5);
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
    }
}
