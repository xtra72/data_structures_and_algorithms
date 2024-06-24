package example.ch6;

public class LinkedQueue implements Queue {
    Node head;

    public LinkedQueue(int size) {
        array = new int[size];
        head = 0;
        tail = 0;

    }

    @Override
    public void add(int element) {
        if (array.length <= tail) {
            throw new QueueFullException();
        }

        array[tail++] = element;
    }

    @Override
    public int element() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        return array[head];
    }

    @Override
    public int remove() {
        if (head == tail) {
            throw new QueueEmptyException();
        }

        return array[head++];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        if (head != tail) {
            stringBuilder.append(String.format("%2d", array[head]));

            for (int i = head + 1; i < tail; i++) {
                stringBuilder.append(String.format(", %2d", array[i]));
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
