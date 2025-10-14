import matplotlib.pyplot as plt
import numpy as np

# Datos extraídos de la ejecución en Java
sizes = [10, 100, 1000, 10000, 100000]

# --- Datos de STACK ---
# Tiempos en nanosegundos (ns)
array_stack_push_times = [31000,20000,283000,679400,5494900]
array_stack_pop_times = [4300,11400,113500,352500,794900]

list_stack_push_times = [1429100,29700,310300,1233700,7341800]
list_stack_pop_times = [3700,16300,160800,482400,790500]

# --- Datos de QUEUE ---
array_queue_enqueue_times = [31300,10700,170500,1694300,5210700]
array_queue_dequeue_times = [8000,146000,3597300,111961000,9450947200]

list_queue_enqueue_times = [941400,26800,522100,868200,6017900]
list_queue_dequeue_times = [3800,16500,157600,468500,1182700]

# Convertir nanosegundos a milisegundos para mejor visualización
ms_converter = 1_000_000.0
array_stack_push_ms = [t / ms_converter for t in array_stack_push_times]
list_stack_push_ms = [t / ms_converter for t in list_stack_push_times]

array_queue_dequeue_ms = [t / ms_converter for t in array_queue_dequeue_times]
list_queue_dequeue_ms = [t / ms_converter for t in list_queue_dequeue_times]

# --- Gráfica 1: Operaciones PUSH de Stacks ---
plt.figure(figsize=(10, 6))
plt.plot(sizes, array_stack_push_ms, marker='o', linestyle='-', label='ArrayStack Push')
plt.plot(sizes, list_stack_push_ms, marker='x', linestyle='--', label='ListStack Push')
plt.xlabel('Tamaño de Entrada (N)')
plt.ylabel('Tiempo de Ejecución (milisegundos)')
plt.title('Comparación de PUSH en Stacks')
plt.xscale('log') # Escala logarítmica para ver mejor los tamaños pequeños
plt.yscale('log')
plt.legend()
plt.grid(True)
plt.show()

# --- Gráfica 2: Operaciones DEQUEUE de Queues (la más importante) ---
plt.figure(figsize=(10, 6))
plt.plot(sizes, array_queue_dequeue_ms, marker='o', linestyle='-', label='ArrayQueue Dequeue (Ineficiente)')
plt.plot(sizes, list_queue_dequeue_ms, marker='x', linestyle='--', label='ListQueue Dequeue (Eficiente)')
plt.xlabel('Tamaño de Entrada (N)')
plt.ylabel('Tiempo de Ejecución (milisegundos)')
plt.title('Comparación de DEQUEUE en Queues')
plt.xscale('log')
plt.yscale('log')
plt.legend()
plt.grid(True)
plt.show()

# --- Gráfica 3: Operaciones POP de Stacks ---
plt.figure(figsize=(10, 6))
plt.plot(sizes, array_stack_pop_times, marker='o', linestyle='-', label='ArrayStack Pop')
plt.plot(sizes, list_stack_pop_times, marker='x', linestyle='--', label='ListStack Pop')
plt.xlabel('Tamaño de Entrada (N)')
plt.ylabel('Tiempo de Ejecución (nanosegundos)')
plt.title('Comparación de POP en Stacks')
plt.xscale('log')
plt.yscale('log')
plt.legend()
plt.grid(True)
plt.show()

# --- Gráfica 4: Operaciones ENQUEUE de Queues ---
plt.figure(figsize=(10, 6))
plt.plot(sizes, array_queue_enqueue_times, marker='o', linestyle='-', label='ArrayQueue Enqueue')
plt.plot(sizes, list_queue_enqueue_times, marker='x', linestyle='--', label='ListQueue Enqueue')
plt.xlabel('Tamaño de Entrada (N)')
plt.ylabel('Tiempo de Ejecución (nanosegundos)')
plt.title('Comparación de ENQUEUE en Queues')
plt.xscale('log')
plt.yscale('log')
plt.legend()
plt.grid(True)
plt.show()