package com.nhnacademy.list;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;

public class Ring<E> extends AbstractList<E> {
    private Node<E> end;
    private int size;

    @Override
    public boolean add(E element) {
        if (size == 0) {
            end = new Node<>(element, null);
            end.next = end;
        } else {
            end = end.next = new Node<>(element, end.next);
        }
        ++size;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = end.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new RingIterator();
    }

    @Override
    public String toString() {
        Node<E> p = end.next;
        StringBuilder buf = new StringBuilder("[" + p.element);
        while (p != end) {
            p = p.next;
            buf.append(", " + p.element);
        }
        buf.append("]");
        return buf.toString();
    }

    public int size() {
        return size;
    }

    private class RingIterator implements Iterator<E> {
        private Node<E> last;
        private Node<E> preLast = end;

        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public E next() {
            if (last == null) {
                last = preLast.next;
            } else {
                preLast = last;
                last = last.next;
            }
            return last.element;
        }

        @Override
        public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }
            if (size == 1) {
                end = preLast = null;
            } else {
                preLast.next = last.next;
            }
            if (last == end) {
                end = preLast;
            }
            last = null;
            --size;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Ring<String> ring = new Ring<>();

        Collections.addAll(ring, "A", "B", "C", "D");
        System.out.println(ring);

        Iterator<String> it = ring.iterator();
        System.out.println("it.next() = " + it.next());
        System.out.println("it.next() = " + it.next());
        System.out.println("it.next() = " + it.next());
        System.out.println("it.next() = " + it.next());
        System.out.println("it.next() = " + it.next());
    }

}