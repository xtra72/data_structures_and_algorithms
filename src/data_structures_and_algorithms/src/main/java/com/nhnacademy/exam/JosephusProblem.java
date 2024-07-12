package com.nhnacademy.exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class JosephusProblem {
    static int solution(int[] items, int skipCount) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int item : items) {
            queue.add(item);
        }

        int count = 0;
        while (queue.size() > 1) {
            int item = queue.poll();
            if (++count <= skipCount) {
                queue.add(item);
            } else {
                System.out.println("killed : " + item);
                count = 0;
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] items = { 1, 2, 3, 4, 5, 6, 7, 8 };

        System.out.println(Arrays.toString(items));
        System.out.println("The lone survivor is " + solution(items, 2));
    }
}
