package example;

import java.util.Arrays;

public class TestCopyOfRange1 {
    public static void main(String... args) {
        int[] numbers1 = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.toString(numbers1));

        int[] numbers2 = Arrays.copyOfRange(numbers1, 2, 5);
        System.out.println(Arrays.toString(numbers2));

    }
}