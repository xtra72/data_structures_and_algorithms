package example;

public class Problem3_4 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node insert(Node start, int x) {
        // PRECONDITIONS: the list is in ascending order, and x > start.data;
        // POSTCONDITIONS: the list is in ascending order, and it contains x;
        if ((start == null) || (start.data > x)) {
            start = new Node(x, start);
        } else {
            Node p = start;
            while (p.next != null) {
                if (p.next.data > x)
                    break;
                p = p.next;
            }
            p.next = new Node(x, p.next);
        }

        return start;
    }

    static void println(Node start) {
        System.out.print("[");
        Node p = start;
        while (p != null) {
            if (p == start) {
                System.out.print(String.format("%2d", p.data));
            } else {
                System.out.print(String.format(", %2d", p.data));
            }
            p = p.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] datas = { 66, 55, 44, 22, 33 };

        Node start = null;

        for (int i = 0; i < 5; i++) {
            start = insert(start, datas[i]);
            println(start);
        }
    }
}
