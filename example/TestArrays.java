package example;

import java.util.Arrays;

public class TestArrays {
    static class XXX implements Comparable {
        String value;

        public XXX(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return value.compareTo(((XXX) o).value);
        }

    }

    public static void main(String[] args) {
        XXX[] a = { new XXX("a"), new XXX("b"), new XXX("c") };
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int k = Arrays.binarySearch(a, new XXX("b"));
        System.out.printf("Arrays.binarySearch(a, 44): %d%n", k);
        System.out.printf("a[%d]: %d%n", k, a[k]);
        k = Arrays.binarySearch(a, 45);
        System.out.printf("Arrays.binarySearch(a, 45): %d%n", k);
        XXX[] b = new XXX[8];
        System.out.println(Arrays.toString(b));
        Arrays.fill(b, new XXX("55"));
        System.out.println(Arrays.toString(b));
        System.out.println("Arrays.equals(a,b): " + Arrays.equals(a, b));
    }
}