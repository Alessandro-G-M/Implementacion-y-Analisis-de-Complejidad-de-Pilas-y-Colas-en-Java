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


class QueueTwoStacks {
    private ArrayStack<Integer> pila_entrada; 
    private ArrayStack<Integer> pila_salida;  

    public QueueTwoStacks() {
        this.pila_entrada = new ArrayStack<>(10);
        this.pila_salida = new ArrayStack<>(10);
    }


    private void asegurarFrente() {
        if (pila_salida.isEmpty()) {
            while (!pila_entrada.isEmpty()){
                pila_salida.push(pila_entrada.pop());
            }
        }
    }
    

    public void enqueue(int x) {
        pila_entrada.push(x);
    }


    public Integer dequeue() {
        asegurarFrente();
        return pila_salida.pop();
    }


    public Integer peek() {
        asegurarFrente();
        return pila_salida.peek();
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int q = scan.nextInt(); 

        QueueTwoStacks queue = new QueueTwoStacks();

        
        for (int i = 0; i < q; i++) {
            
            int queryType = scan.nextInt(); 
            
            switch (queryType) {
                case 1:
                    int x = scan.nextInt(); 
                    queue.enqueue(x); 
                    break;
                case 2:
                    queue.dequeue(); 
                    break;
                case 3:
                    System.out.println(queue.peek()); 
                    break;
            }
        }
        scan.close();
    }
}
