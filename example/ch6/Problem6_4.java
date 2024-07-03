package example.ch6;

public class Problem6_4 {
    public static void main(String[] args) {
        final int LOOP_COUNT = 100000;
        final int LOOP_COUNT2 = 1000000;
        ArrayQueue3 arrayQueue = new ArrayQueue3(5);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayQueue.add(i);
        }
        for (int i = 0; i < LOOP_COUNT; i++) {
            arrayQueue.remove();
        }
        long finishedTime = System.currentTimeMillis();

        System.out.printf("Case 1%n");
        System.out.printf("ArrayQueue3 : %d loops = %d ms%n", LOOP_COUNT, finishedTime - startTime);

        LinkedQueue2 linkedQueue = new LinkedQueue2();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedQueue.add(i);
        }
        for (int i = 0; i < LOOP_COUNT; i++) {
            linkedQueue.remove();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("LinkedQueue2 : %d loops = %d ms%n", LOOP_COUNT, finishedTime - startTime);

        ArrayQueue3 arrayQueue2 = new ArrayQueue3(5);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT2; i++) {
            arrayQueue2.add(i);
            arrayQueue2.remove();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("Case 2%n");
        System.out.printf("ArrayQueue3 : %d loops = %d ms%n", LOOP_COUNT2, finishedTime - startTime);

        LinkedQueue2 linkedQueue2 = new LinkedQueue2();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < LOOP_COUNT2; i++) {
            linkedQueue2.add(i);
            linkedQueue2.remove();
        }
        finishedTime = System.currentTimeMillis();

        System.out.printf("LinkedQueue2 : %d loops = %d ms%n", LOOP_COUNT2, finishedTime - startTime);
    }
}
