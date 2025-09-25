package java.main.LinkedList.LinkedListAplications;

import java.main.LinkedList.DoubleLinkedList;

/**
 * Desafio: Navegação de Páginas
 * Justificativa: DoubleLinkedList. A necessidade de avançar e voltar entre as páginas
 * é feito pelos ponteiros 'next' e 'prev'
 */
public class PageNavigation {

    private static class Page {
        String url;
        public Page(String url) { this.url = url; }
        @Override public String toString() { return "Página: " + url; }
    }

    private final DoubleLinkedList<Page> history = new DoubleLinkedList<>();
    private DoubleLinkedList.Node<Page> currentPageNode;

    public void visitPage(String url) {

        // Ao acessar uma nova página, o metódo de avançar deve ser perdido
        while (currentPageNode != null && currentPageNode.next != null) {
            history.remove(currentPageNode.next);
        }

        history.add(new Page(url));

        // A nova página é sempre a cauda da lista
        currentPageNode = history.getTail();
        System.out.println("Visitando: " + currentPageNode.data.url);
    }

    public Page goBack() {
        if (currentPageNode != null && currentPageNode.prev != null) {
            currentPageNode = currentPageNode.prev;
            return currentPageNode.data;
        }
        System.out.println("Não há mais histórico para voltar.");
        return currentPageNode != null ? currentPageNode.data : null;
    }

    public Page goForward() {
        if (currentPageNode != null && currentPageNode.next != null) {
            currentPageNode = currentPageNode.next;
            return currentPageNode.data;
        }
        System.out.println("Não há mais histórico para avançar.");
        return currentPageNode != null ? currentPageNode.data : null;
    }

    public static void main(String[] args) {
        PageNavigation browser = new PageNavigation();
        browser.visitPage("google.com");
        browser.visitPage("psalms.site");
        browser.visitPage("github.com");

        System.out.println("Voltou para: " + browser.goBack());
        System.out.println("Voltou para: " + browser.goBack());
        System.out.println("Avançou para: " + browser.goForward());

        // Visita uma nova página, apagando o histórico
        browser.visitPage("apoiaazul.com");

        // O histórico de avançar será perdido
        System.out.println("Tentando avançar: \n" + browser.goForward());
    }
}