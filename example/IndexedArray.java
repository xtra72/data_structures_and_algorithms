package example;

public class IndexedArray {
    int[] a;
    int[] k;

    public IndexedArray(int size) {
        a = new int[size];
        k = new int[0];
    }

    public void insert(int x) {
        int i = 0;

        while (i < k.length && a[k[i]] <= x) {
            ++i;
        }

        int[] newK = new int[k.length + 1];

        System.arraycopy(k, 0, newK, 0, i);
        System.arraycopy(k, i, newK, i + 1, k.length - i);
        a[k.length] = x;
        newK[i] = k.length;

        k = newK;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        if (k.length > 0) {
            builder.append(String.format("%3d", a[k[0]]));
        }

        for (int i = 1; i < k.length; i++) {
            builder.append(String.format(", %3d", a[k[i]]));
        }
        builder.append("]");

        return builder.toString();
    }
}