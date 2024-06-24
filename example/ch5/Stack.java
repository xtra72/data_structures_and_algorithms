package example.ch5;

public interface Stack<E> {
    public void push(E element);

    public E peek();

    public E pop();

    public int size();

    public boolean isEmpty();
}
