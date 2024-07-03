package example.ch9;

public class Problem9_3 {
    public static int fibonacci(int n) {
        System.out.printf("called fibonacci(%d)%n", n);
        if ((n == 0) || (n == 1)) {
            System.out.printf("return fibonacci(%d) = 1%n", n);
            return 1;
        } else {
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.printf("return fibonacci(%d) = fibonacci(%d) + fibonacci(%d) = %d%n",
                    n, n - 1, n - 2, result);
            return result;
        }
    }

    public static void main(String[] args) {
        int n = 5;

        int result = fibonacci(n);
        System.out.printf("fibonacci(%d) = %d%n", n, result);

    }
}
