package example;

public class Problem3_5 {
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

    static Node delete(Node start, int x) {
        // precondition: the list is in ascending order;
        // postconditions: the list is in ascending order, and if it did
        // contains x, then the first occurrence of x has been deleted;
        if (start == null || start.data > x) { // x is not in the list
            return start;
        } else if (start.data == x) { // x is the first element in the list
            return start.next;
        }
        for (Node p = start; p.next != null; p = p.next) {
            if (p.next.data > x) {
                break; // x is not in the list
            } else if (p.next.data == x) { // x is in the p.next node
                p.next = p.next.next; // delete it
                break;
            }
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

        start = delete(start, 44);
        println(start);
    }
}
