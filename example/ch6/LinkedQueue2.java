package example.ch6;

public class LinkedQueue2 implements Queue {
    Node head;
    Node tail;
    int size = 0;

    public LinkedQueue2() {
        tail = new Node(0);
        head = tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int element) {
        tail.setData(element);
        tail.setNext(new Node(0));

        tail = tail.getNext();
        ++size;
    }

    @Override
    public int element() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        return head.getData();
    }

    @Override
    public int remove() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        Node firstNode = head;
        head = head.getNext();
        firstNode.setNext(null);
        size--;

        return firstNode.getData();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        if (head != tail) {
            Node current = head;
            stringBuilder.append(String.format("%2d", current.getData()));
            current = current.getNext();
            while (current != tail) {
                stringBuilder.append(String.format(", %2d", current.getData()));
                current = current.getNext();
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Queue queue = new ArrayQueue(5);

        System.out.println("queue : " + queue);
        queue.add(1);
        System.out.println("queue : " + queue);
        queue.add(2);
        System.out.println("queue : " + queue);
        queue.add(3);
        System.out.println("queue : " + queue);
        queue.add(4);
        System.out.println("queue : " + queue);
        queue.add(5);
        System.out.println("queue : " + queue);
        queue.remove();
        System.out.println("queue : " + queue);
        queue.remove();
        System.out.println("queue : " + queue);
        queue.remove();
        System.out.println("queue : " + queue);
        queue.remove();
        System.out.println("queue : " + queue);
        queue.remove();
        System.out.println("queue : " + queue);
    }
}
