package java.main.LinkedList.Problems;

import java.main.LinkedList.Implemations.DoubleLinkedList;

/**
 * Desafio: Playlist de Músicas com loop contínuo
 * Justificativa: DoubleLinkedList. Permite navegar para frente e para trás e
 * O controle do loop é feito na aplicação: ao chegar no fim, o próximo é a cabeça;
 * ao chegar no início, o anterior é a cauda. Assim, mantém o loop infinito solicitado
 */
public class MusicPlaylist {

    private static class Music {
        String name;
        public Music(String name) { this.name = name; }
        @Override public String toString() { return  name; }
    }

    private final DoubleLinkedList<Music> playlist = new DoubleLinkedList<>();
    private DoubleLinkedList.Node<Music> currentMusicNode;

    public void addMusic(String name) {
        playlist.add(new Music(name));
        if (currentMusicNode == null) {
            currentMusicNode = playlist.getHead();
        }
    }

    public Music playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist vazia.");
            return null;
        }
        // Se o próximo não existe (estamos na cauda), volte para o início (loop)
        if (currentMusicNode.next == null) {
            currentMusicNode = playlist.getHead();
        } else {
            currentMusicNode = currentMusicNode.next;
        }
        return currentMusicNode.data;
    }

    public Music playPrevious() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist vazia.");
            return null;
        }
        // Se o anterior não existe (estamos na cabeça), vá para o fim (loop)
        if (currentMusicNode.prev == null) {
            currentMusicNode = playlist.getTail();
        } else {
            currentMusicNode = currentMusicNode.prev;
        }
        return currentMusicNode.data;
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addMusic("90210");
        playlist.addMusic("Never Recover");
        playlist.addMusic("Skeletons");
        playlist.addMusic("Top Floor");


        System.out.println("Iniciando playlist, tocando: \n" + playlist.currentMusicNode.data);
        System.out.println("Próxima: " + playlist.playNext());
        System.out.println("Próxima: " + playlist.playNext());
        System.out.println("Próxima: " + playlist.playNext());
        System.out.println("Próxima (loop): " + playlist.playNext());
        System.out.println("Anterior: " + playlist.playPrevious());
        System.out.println("Anterior (loop): " + playlist.playPrevious());
    }
}