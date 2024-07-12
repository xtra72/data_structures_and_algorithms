package com.nhnacademy.array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestExam03 {
    static final int[] targetA = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static final boolean[] targetB = { true, false, true, false, true, false, true, false, true };
    static final double[] targetC = { 3.141592653589793, 12.566370614359172, 28.274333882308138, 50.26548245743669,
            78.53981633974483, 113.09733552923255, 153.93804002589985, 201.06192982974676, 254.46900494077323 };
    static final int[][] targetD = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 2, 4, 6, 8, 10, 12, 14, 16, 18 },
            { 3, 6, 9, 12, 15, 18, 21, 24, 27 },
            { 4, 8, 12, 16, 20, 24, 28, 32, 36 },
            { 5, 10, 15, 20, 25, 30, 35, 40, 45 },
            { 6, 12, 18, 24, 30, 36, 42, 48, 54 },
            { 7, 14, 21, 28, 35, 42, 49, 56, 63 },
            { 8, 16, 24, 32, 40, 48, 56, 64, 72 },
            { 9, 18, 27, 36, 45, 54, 63, 72, 81 }
    };
    static final Logger log = LogManager.getLogger(TestExam03.class);

    @Test
    void testIntArrayA() {
        int[] a = new int[9];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        assertTrue(Arrays.equals(targetA, a));
    }

    @Test
    void testBooleanArrayB() {
        boolean[] b = new boolean[targetA.length];
        for (int i = 0; i < targetA.length; i++) {
            b[i] = targetA[i] % 2 != 0;
        }
        assertTrue(Arrays.equals(targetB, b));
    }

    @Test
    void testCircleArea() {
        double[] c = new double[targetA.length];
        for (int i = 0; i < targetB.length; i++) {
            c[i] = Math.pow(targetA[i], 2) * Math.PI;
        }

        assertTrue(Arrays.equals(targetC, c));
    }

    @Test
    void testMultiplicationTable() {
        int[][] d = new int[9][9];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = (i + 1) * (j + 1);
            }
        }

        assertAll(() -> {
            assertEquals(targetD.length, d.length);
            for (int i = 0; i < d.length; i++) {
                assertTrue(Arrays.equals(targetD[i], d[i]));
            }
        });
    }
}
