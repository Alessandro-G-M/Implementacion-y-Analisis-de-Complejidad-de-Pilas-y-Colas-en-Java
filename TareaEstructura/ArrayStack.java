public class ArrayStack<T> implements MyStack<T> {
    private int size;
    private T[] data;

    public ArrayStack(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void push(T item) {
        if(data.length == size){
            increaseCapacity();
        }
        data[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay más elementos en la pila");
        }
        T item = data[size-1];
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay más elementos en la pila");
        }
        return data[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
