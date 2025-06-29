package LinkedList;

public class CircleLinkedList<T> {

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head; // Aponta para si mesmo
        } else {
            Node<T> tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
        size++;
    }


    public void remove(Node<T> nodeToRemove) {
        if (isEmpty() || nodeToRemove == null) return;

        // Encontrar o nó anterior ao que será removido
        Node<T> current = head;
        Node<T> prev = null;
        do {
            if (current == nodeToRemove) {
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        // Se o nó foi encontrado
        if (current == nodeToRemove) {
            // Se for o único nó
            if (size == 1) {
                head = null;
            } else {
                prev.next = current.next; // O anterior aponta para o próximo

                // Se remover a cabeça, a nova cabeça é o próxim
                if (current == head) {
                    head = current.next;
                }
            }
            size--;
        }
    }
}