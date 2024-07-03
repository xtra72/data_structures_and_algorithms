package example.ch11;

public class Example11_1 {
    public static void main(String[] args) {

        String x = "ABCDE";
        String y = new String("ABCDE");
        String z = new String("ABCDE");
        System.out.println("x = " + x);
        System.out.println("x = " + x);
        System.out.println("z = " + z);
        System.out.println("(x == y) = " + (x == y));
        System.out.println("(y == z) = " + (y == z));
        System.out.println("x.equals(y) = " + x.equals(y));
        System.out.println("y.equals(z) = " + y.equals(z));
    }
}
