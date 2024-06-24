package example;

public class DuplicatingArrays {
    public static void main(String[] args) {
        int[] a = { 22, 44, 66, 88 };
        print("a", a);
        int[] b = a.clone(); // duplicate a[] in b[]
        print("b", b);
        String[] c = { "AB", "CD", "EF" };
        print("c", c);
        String[] d = c.clone(); // duplicate c[] in d[]
        print("d", d);
        c[1] = "XYZ"; // change c[], but not d[]
        print("c", c);
        print("d", d);

        StringBuilder[] e = { new StringBuilder("AB"),
                new StringBuilder("CD"),
                new StringBuilder("EF") };
        print("e", e);
        StringBuilder[] f = e.clone();
        print("f", f);
        e[1].append("CD");
        print("e", e);
        print("f", f);
    }

    public static void print(String title, int[] a) {
        System.out.printf("%s : {%d", title, a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.printf(", %d", a[i]);
        }
        System.out.println("}");
    }

    public static void print(String title, Object[] a) {
        System.out.printf("%s : {%s", title, a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.printf(", %s", a[i]);
        }
        System.out.println("}");
    }
}