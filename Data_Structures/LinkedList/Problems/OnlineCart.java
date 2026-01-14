package java.main.LinkedList.Problems;

import java.main.LinkedList.Implemations.DoubleLinkedList;

/**
 * Desafio: Carrinho de Compras Online
 * Justificativa: DoubleLinkedList. A principal vantagem é poder percorrer
 * para frente e para trás para rever e poder realizar a remoção em qualquer ponto da lista
 */
public class OnlineCart {

    private static class CartItem {
        String name;
        public CartItem(String name) { this.name = name; }
        @Override public String toString() { return "Item: " + name; }
    }

    private final DoubleLinkedList<CartItem> items = new DoubleLinkedList<>();

    public void addItem(String name) {
        items.add(new CartItem(name));
    }

    public void removeItem(String name) {
        DoubleLinkedList.Node<CartItem> current = items.getHead();
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) {
                items.remove(current);
                System.out.println(current.data + " removido.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item '" + name + "' não encontrado.");
    }

    public void reviewCart() {
        System.out.println("\n--- Revisando Carrinho ---");
        DoubleLinkedList.Node<CartItem> current = items.getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        OnlineCart cart = new OnlineCart();
        cart.addItem("Notebook");
        cart.addItem("Mouse");
        cart.addItem("Teclado");
        cart.reviewCart();
        cart.removeItem("Mouse");
        cart.reviewCart();
    }
}