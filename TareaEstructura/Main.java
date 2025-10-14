public class Main {

    public static void main(String[] args) {
        // Tamaños de entrada para las pruebas
        int[] sizes = {10, 100, 1000, 10000, 100000};

        System.out.println("--- Análisis Experimental de Estructuras de Datos ---");

        System.out.println("\nResultados para ArrayStack (Pila con Arreglo):");
        System.out.println("Tamaño\t\tTiempo Push (ns)\tTiempo Pop (ns)");
        for (int size : sizes) {
            testArrayStack(size);
        }

        System.out.println("\nResultados para ListStack (Pila con Lista Enlazada):");
        System.out.println("Tamaño\t\tTiempo Push (ns)\tTiempo Pop (ns)");
        for (int size : sizes) {
            testListStack(size);
        }

        System.out.println("\nResultados para ArrayQueue (Cola con Arreglo):");
        System.out.println("Tamaño\t\tTiempo Enqueue (ns)\tTiempo Dequeue (ns)");
        for (int size : sizes) {
            testArrayQueue(size);
        }

        System.out.println("\nResultados para ListQueue (Cola con Lista Enlazada):");
        System.out.println("Tamaño\t\tTiempo Enqueue (ns)\tTiempo Dequeue (ns)");
        for (int size : sizes) {
            testListQueue(size);
        }
    }

    public static void testArrayStack(int n) {
        MyStack<Integer> stack = new ArrayStack<>(n);

        // Medir tiempo de Push
        long startTimePush = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        long endTimePush = System.nanoTime();
        long durationPush = endTimePush - startTimePush;

        // Medir tiempo de Pop
        long startTimePop = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long endTimePop = System.nanoTime();
        long durationPop = endTimePop - startTimePop;
        
        System.out.printf("%d\t\t%d\t\t\t%d%n", n, durationPush, durationPop);
    }

    public static void testListStack(int n) {
        MyStack<Integer> stack = new ListStack<>();
        
        // Medir tiempo de Push
        long startTimePush = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        long endTimePush = System.nanoTime();
        long durationPush = endTimePush - startTimePush;

        // Medir tiempo de Pop
        long startTimePop = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long endTimePop = System.nanoTime();
        long durationPop = endTimePop - startTimePop;

        System.out.printf("%d\t\t%d\t\t\t%d%n", n, durationPush, durationPop);
    }

    public static void testArrayQueue(int n) {
        MyQueue<Integer> queue = new ArrayQueue<>(n);

        // Medir tiempo de Enqueue
        long startTimeEnqueue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        long endTimeEnqueue = System.nanoTime();
        long durationEnqueue = endTimeEnqueue - startTimeEnqueue;

        // Medir tiempo de Dequeue
        long startTimeDequeue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long endTimeDequeue = System.nanoTime();
        long durationDequeue = endTimeDequeue - startTimeDequeue;

        System.out.printf("%d\t\t%d\t\t\t%d%n", n, durationEnqueue, durationDequeue);
    }

    public static void testListQueue(int n) {
    MyQueue<Integer> queue = new ListQueue<>();
    try {
        long startTimeEnqueue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        long endTimeEnqueue = System.nanoTime();
        long durationEnqueue = endTimeEnqueue - startTimeEnqueue;

        long startTimeDequeue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long endTimeDequeue = System.nanoTime();
        long durationDequeue = endTimeDequeue - startTimeDequeue;

        System.out.printf("%d\t\t%d\t\t\t%d%n", n, durationEnqueue, durationDequeue);

        // Corregido
        } catch (Throwable t) { // Usar Throwable para capturar Errores y Excepciones
            System.out.println("Error en ListQueue con n=" + n + ": " + t);
            t.printStackTrace();
        }
    }
}