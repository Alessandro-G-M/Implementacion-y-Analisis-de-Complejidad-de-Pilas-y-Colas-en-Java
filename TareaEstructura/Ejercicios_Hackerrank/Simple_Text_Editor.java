import java.io.*;
import java.util.*;

class ArrayStack<T>{
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

    
    public void push(T item) {
        if(data.length == size){
            increaseCapacity();
        }
        data[size] = item;
        size++;
    }

    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay mas elementos en la pila");
        }
        T item = data[size-1];
        size--;
        return item;
    }

    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: no hay mas elementos en la pila");
        }
        return data[size-1];
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public int size() {
        return size;
    }
}

class UndoAction {
    int operationType;
    String dataToRevert; 

    public UndoAction(int type, String data) {
        this.operationType = type;
        this.dataToRevert = data;
    }
}





public class Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();

        StringBuilder S = new StringBuilder();
        
        ArrayStack<UndoAction> history_stack = new ArrayStack<>(20);

        
        for (int i = 0; i < Q; i++) {
            
            int queryType = scan.nextInt(); 
            
            switch (queryType) {
                

                case 1:
                    String W = scan.next();
                    history_stack.push(new UndoAction(1, String.valueOf(W.length())));
                    S.append(W);
                    break;
                    

                case 2:
                    int k = scan.nextInt();                     
                    int start = S.length() - k; 
                    int end = S.length(); 
                    
                    String deleted_string = S.substring(start, end);
                    history_stack.push(new UndoAction(2, deleted_string));
                    
                    
                    S.delete(start, end); 
                    break;

                case 3:

                    int k_print = scan.nextInt();
                    System.out.println(S.charAt(k_print - 1)); 
                    break;

                case 4:
                    if (!history_stack.isEmpty()){
                        UndoAction action = history_stack.pop();
                        
                        switch (action.operationType){
                            
                            case 1:
                                int lengthToCut = Integer.parseInt(action.dataToRevert);
                                S.setLength(S.length() - lengthToCut);
                                break;
                            case 2:
                                S.append(action.dataToRevert);
                                break;
                            
                        }
                    }
                    break;
            }
        }
        scan.close();
    }
}