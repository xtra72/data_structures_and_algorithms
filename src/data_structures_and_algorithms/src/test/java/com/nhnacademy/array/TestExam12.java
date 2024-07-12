package com.nhnacademy.array;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestExam12 {
    @Test
    void testObjectSubArray() {
        int[] targetValues = { 5, 6, 7 };
        Problem05.Box[] targetBoxes = new Problem05.Box[3];

        for (int i = 0; i < 3; i++) {
            targetBoxes[i] = new Problem05.Box(targetValues[i]);
        }

        assertTrue(Arrays.equals(targetBoxes, Problem05.solution()));
    }
}
