
public class ArrayQueue<T> implements MyQueue<T>{
    private int size;
    private T[] data;

    // Constructor
    public ArrayQueue(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // Double the capacity of the array if needed
    private void increaseCapacity(){
        int newCapacity = data.length*2;
        T[] newData = (T[]) new Object[newCapacity];
        for(int i= 0; i< data.length; i++){
            newData[i] = data[i];               
        }
        data = newData;
    }

    @Override
    public void enqueue(T item) {
        if(data.length == size){
            increaseCapacity();                 
        }
        data[size] = item;                      
        size++;
    }

    @Override
    public T dequeue(){
        if(size == 0){
            throw new RuntimeException("Underflow: no hay más elementos en cola"); 
        }
        T item = data[0];
        for(int i = 0; i<size-1; i++){
            data[i] = data[i+1];
        }          
        size--;
        return item;
            
        }
    @Override
    public T front() {
        return data[0];                        
    }

    @Override
    public boolean isEmpty() {
        return size==0;                        
    }

    @Override
    public int size() {
        return size;                            
    }

}
