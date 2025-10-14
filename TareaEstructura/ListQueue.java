public class ListQueue<T> implements MyQueue<T>{

    private class NodeGeneric<t> {
        T data;
        NodeGeneric<T> next;
        
        public NodeGeneric(T data) {
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
        if(head == rear){
            size--;
            return head.data;
        }
        NodeGeneric<T> item = head;
        head = head.next;

        size--;
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
