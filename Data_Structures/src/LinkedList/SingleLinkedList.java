package LinkedList;


public class SingleLinkedList<T> {

   // classe interna
    private static class Node<T> {
        T data; // tipo genérico T
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Retorna o tamanho em tempo O(1)
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean search(T value) {
        Node<T> current = head;
        while (current != null) {
            // Usar .equals() para comparar objetos é mais eficiente que utilizar operador lógico
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T value) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.data.equals(value)) {
            previous = current;
            current = current.next;
        }

        // Se o valor não foi encontrado
        if (current == null) {
            return;
        }

        // Se o nó a ser removido é a cabeça
        if (previous == null) {
            head = current.next;
            // Se a lista ficou vazia após a remoção
            if (head == null) {
                tail = null;
            }
        } else {
            previous.next = current.next;
            // Se o nó a ser removido era a cauda
            if (current == tail) {
                tail = previous;
            }
        }
        size--;
    }
}