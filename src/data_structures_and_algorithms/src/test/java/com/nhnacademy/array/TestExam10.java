package com.nhnacademy.array;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestExam10 {
    @Test
    void testCopyOfRange() {
        Integer[] target = { 5, 8 };
        Integer[] integers = { 1, 1, 2, 3, 5, 8, 13 };

        Number[] numbers = Arrays.copyOfRange(integers, 4, 6, Number[].class);

        assertTrue(Arrays.equals(target, numbers));
    }
}
