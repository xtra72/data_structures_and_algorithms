package example;

import java.util.Arrays;

public class TestCopyOfRange3 {
    static class Box {
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
    }

    public static void main(String[] args) {
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

        System.out.println(Arrays.toString(subBoxes));
    }
}
