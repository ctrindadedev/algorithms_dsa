package java.main.LinkedList.Problems;

import java.main.LinkedList.Implemations.DoubleLinkedList;

/**
 * Desafio: Histórico de Pedidos
 * Justificativa: DoubleLinkedList. A principal vantagem é poder percorrer
 * para frente e para trás para rever e poder realizar a remoção em qualquer ponto da lista
 */
public class OrderHistoric {

    private static class Order {
        int id;
        public Order(int id) { this.id = id; }
        @Override public String toString() { return "Pedido #" + id; }
    }

    private final DoubleLinkedList<Order> historic = new DoubleLinkedList<>();
    private int nextId = 1;

    public void addOrder() {
        historic.add(new Order(nextId++));
    }

    public void cancelOrder(int id) {
        DoubleLinkedList.Node<Order> current = historic.getHead();
        while (current != null) {
            if (current.data.id == id) {
                historic.remove(current);
                System.out.println("Pedido #" + id + " cancelado.");
                return;
            }
            current = current.next;
        }
        System.out.println("Pedido #" + id + " não encontrado.");
    }

    public void listAllOrders() {
        System.out.println("\n--- Histórico de Pedidos ---");
        DoubleLinkedList.Node<Order> current = historic.getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        OrderHistoric historic = new OrderHistoric();
        historic.addOrder();
        historic.addOrder();
        historic.addOrder();
        historic.listAllOrders();
        historic.cancelOrder(2);
        historic.listAllOrders();
    }
}