
public interface MyQueue<T> {
    void enqueue(T a);
    T dequeue();
    T front();
    boolean isEmpty();
    int size();
}
