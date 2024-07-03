package example.ch14;

import java.util.Random;

public class Problem14_5 {
    public static void sort(int[] a) {
        // POSTCONDITION: a[0] <= a[1] <= ... <= a[a.length-1];
        sort(a, 0, a.length);
    }

    private static void sort(int[] a, int p, int q) {
        // PRECONDITION: 0 <= p <= q <= a.length
        // POSTCONDITION: a[p..q) is sorted;
        if (q - p < 2) {
            return;
        }
        int m = partition(a, p, q); // step 2
        sort(a, p, m); // step 4
        sort(a, m + 1, q); // step 5
    }

    private static int partition(int[] a, int p, int q) {
        // RETURNS: index m of pivot element a[m];
        // POSTCONDITION: a[i] <= a[m] <= a[j] for p <= i <= m <= j < q;
        int pivot = a[p], i = p, j = q; // steps 1-2
        while (i < j) { // step 3
            while (i < j && a[--j] >= pivot)
                ; // step 4
            if (i < j) {
                a[i] = a[j]; // step 5
            }
            while (i < j && a[++i] <= pivot)
                ; // step 6
            if (i < j) {
                a[j] = a[i]; // step 7
            }
        }
        a[j] = pivot; // step 8
        return j;
    }

    public static void main(String[] args) {
        int n = 200;
        int[] a = new int[200];

        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(n * 10);
        }

        Utils.print(a);
        sort(a);
        Utils.print(a);
    }

}
