package example;

public class Utils {

    private Utils() {
    }

    public static String toString(int[] a) {
        StringBuilder string = new StringBuilder();

        string.append("[");
        if (a.length > 0) {
            string.append(String.format("%3d", a[0]));
        }

        for (int i = 1; i < a.length; i++) {
            string.append(String.format(", %3d", a[i]));
        }

        string.append("]");

        return string.toString();
    }
}
