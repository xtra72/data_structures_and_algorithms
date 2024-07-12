package com.nhnacademy.list;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Exam03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C", "D", "E", "F", "G", "H");
        System.out.println(list);
        ListIterator<String> it = list.listIterator();
        System.out.println("it.nextIndex(): " + it.nextIndex());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.previousIndex(): " + it.previousIndex());
        System.out.println("it.nextIndex(): " + it.nextIndex());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.previous(): " + it.previous());
        System.out.println("it.previousIndex(): " + it.previousIndex());
        System.out.println("it.nextIndex(): " + it.nextIndex());
        System.out.println("it.previous(): " + it.previous());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.next(): " + it.next());
        System.out.println("it.add(\"X\"):");
        it.add("X");
        System.out.println(list);
        System.out.println("it.next(): " + it.next());
        System.out.println("it.set(\"Y\"):");
        it.set("Y");
        System.out.println(list);
        System.out.println("it.next(): " + it.next());
        System.out.println("it.remove():");
        it.remove();
        System.out.println("it.next(): " + it.next());
        System.out.println(list);
    }
}