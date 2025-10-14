public class ListQueue<T> implements MyQueue<T>{

    private class NodeGeneric<U> {
        U data;
        NodeGeneric<U> next;
        
        public NodeGeneric(U data) {
            this.data = data;
            next = null;
        }
    }

    private int size;
    private NodeGeneric<T> head;
    private NodeGeneric<T> rear;

    @Override
    public void enqueue(T a) {
        NodeGeneric<T> item = new NodeGeneric<>(a);
        if(isEmpty()){
            head = item;
            rear = item;
        } else{
            rear.next = item;
            rear = item;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay más elementos en cola");
        }
        
        NodeGeneric<T> item = head;
        head = head.next;
        size--;

        if (head == null) {
            rear = null; 
        }

        return item.data;
    }

    @Override
    public T front() {
        return head.data;
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
