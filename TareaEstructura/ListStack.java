public class ListStack<T> implements MyStack<T>{

    private class NodeGeneric<t> {
        T data;
        NodeGeneric<T> next;
        
        public NodeGeneric(T data) {
            this.data = data;
            next = null;
        }
    }

    private int size;
    private NodeGeneric<T> top;

    @Override
    public void push(T val) {
        if(isEmpty()){
            top = new NodeGeneric<>(val);
            size++;
        } else{
            NodeGeneric<T> item = new NodeGeneric<>(val);
            item.next = top;
            top = item;
            size++;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay más elementos en cola");
        }
        if(top.next == null){
            size--;
            return top.data;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        return top.data;
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
