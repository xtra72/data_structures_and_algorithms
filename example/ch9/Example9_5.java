package example.ch9;

public class Example9_5 {
    public static void main(String[] args) {
        String fmt1 = "%18s%18s%18s%n";
        String fmt2 = "%18.13f%18.13f%18.13f%n";
        System.out.printf(fmt1, "s(x)  ", "Math.sin(x) ", "error  ");
        for (double x = 0.0; x < 1.0; x += 0.1) {
            System.out.printf(fmt2, s(x), Math.sin(x), Math.sin(x) - s(x));
        }
        System.out.printf(fmt1, "c(x)  ", "Math.cos(x) ", "error  ");
        for (double x = 0.0; x < 1.0; x += 0.1) {
            System.out.printf(fmt2, c(x), Math.cos(x), c(x) - Math.cos(x));
        }
    }

    public static double s(double x) {
        if (-0.005 < x && x < 0.005) {
            return x - x * x * x / 6; // basis
        }
        return 2 * s(x / 2) * c(x / 2); // recursion
    }

    public static double c(double x) {
        if (-0.005 < x && x < 0.005) {
            return 1.0 - x * x / 2; // basis
        }
        return 1 - 2 * s(x / 2) * s(x / 2); // recursion
    }
}