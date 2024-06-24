package example;

import java.util.Arrays;
import java.io.Serializable;

class Exam1 implements Serializable {
    public static void main(String[] args) {
        Integer[][] ints = new Integer[5][2];

        long index = 2;
        Byte b = 1;

        ints[1] = new Integer[100];
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints[0]));
        System.out.println(Arrays.toString(ints[1]));
    }
}
