package com.nhnacademy.array;

import java.util.Arrays;

public class Exam09 {

    public static void main(String... args) {
        Integer[] integers = { 1, 1, 2, 3, 5, 8, 13 };
        System.out.println(Arrays.toString(integers));

        Number[] numbers = Arrays.copyOfRange(integers, 4, 6, Number[].class);

        System.out.println(Arrays.toString(numbers));
    }
}
