package java.main.LinkedList.LinkedListAplications;

import java.main.LinkedList.CircleLinkedList;

/**
 * Desafio: Rodízio de Jogadores
 * Justificativa: CircleLinkedList. Numa situação de rodizio, onde o próximo
 * do último elemento é o primeiro. A navegação se torna um loop infinito natural
 */
public class RodizioJogadores {

    private static class Player {
        String name;
        public Player(String name) { this.name = name; }
        @Override public String toString() { return "Jogador: " + name; }
    }

    private final CircleLinkedList<Player> players = new CircleLinkedList<>();
    private CircleLinkedList.Node<Player> currentPlayerNode;

    public void addPlayer(String name) {
        players.add(new Player(name));
        if (currentPlayerNode == null) {
            currentPlayerNode = players.getHead();
        }
    }

    public Player nextTurn() {
        if (players.isEmpty()) {
            System.out.println("Não há jogadores.");
            return null;
        }
        Player playerOfThisTurn = currentPlayerNode.data;
        currentPlayerNode = currentPlayerNode.next;
        return playerOfThisTurn;
    }

    public static void main(String[] args) {
        RodizioJogadores game = new RodizioJogadores();
        game.addPlayer("Cristiano Ronaldo");
        game.addPlayer("Messi");
        game.addPlayer("Vinicius Junior");

        System.out.println("Vez de: " + game.nextTurn().name);
        System.out.println("Vez de: " + game.nextTurn().name);
        System.out.println("Vez de: " + game.nextTurn().name);
        System.out.println("Vez de (loop): " + game.nextTurn().name);
    }
}