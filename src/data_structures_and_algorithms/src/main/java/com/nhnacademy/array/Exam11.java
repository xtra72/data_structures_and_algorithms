package com.nhnacademy.array;

import java.util.Arrays;

public class Exam11 {
    public static class Box {
        int value;

        public Box(int value) {
            this.value = value;
        }

        public void up() {
            value++;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            return ((o instanceof Box) && (((Box) o).value == value));
        }
    }

    public static Box[] solution() {
        Box[] boxes = new Box[10];

        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(i + 1);
        }

        System.out.println(Arrays.toString(boxes));

        Box[] subBoxes = Arrays.copyOfRange(boxes, 3, 6);
        System.out.println(Arrays.toString(subBoxes));
        for (int i = 0; i < subBoxes.length; i++) {
            subBoxes[i].up();
        }

        return subBoxes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }
}
