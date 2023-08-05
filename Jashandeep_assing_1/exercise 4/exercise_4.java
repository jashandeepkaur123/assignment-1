import java.util.Random;

class Song {
    String title;
    String artist;
    int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}

class Node {
    Song song;
    Node next;
    Node prev;

    public Node(Song song) {
        this.song = song;
    }
}

class Playlist {
    private Node head;
    private Node tail;
    private int size;

    public void addToBeginning(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addToEnd(Song song) {
        Node newNode = new Node(song);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void removeFromBeginning() {
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
        }
    }

    public void removeFromEnd() {
        if (tail != null) {
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            size--;
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapNodes(i, j);
        }
    }

    private void swapNodes(int i, int j) {
        Node node1 = getNodeAtIndex(i);
        Node node2 = getNodeAtIndex(j);

        Song temp = node1.song;
        node1.song = node2.song;
        node2.song = temp;
    }

    private Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void printPlaylist() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.song.title +
                    ", Artist: " + current.song.artist +
                    ", Duration: " + current.song.duration + " seconds");
            current = current.next;
        }
    }
}

public class exercise_4 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addToEnd(new Song("Song 1", "Artist 1", 180));
        playlist.addToEnd(new Song("Song 2", "Artist 2", 210));
        playlist.addToEnd(new Song("Song 3", "Artist 3", 190));
        playlist.addToEnd(new Song("Song 4", "Artist 4", 180));
        playlist.addToEnd(new Song("Song 5", "Artist 5", 210));
        playlist.addToEnd(new Song("Song 6", "Artist 6", 190));

        playlist.addToBeginning(new Song("New Song", "New Artist", 220));

        playlist.removeFromBeginning();

        playlist.removeFromEnd();

        System.out.println("Playlist:");
        playlist.printPlaylist();

        System.out.println("\nShuffled Playlist:");
        playlist.shuffle();
        playlist.printPlaylist();

        System.out.println("\nShuffled Playlist again:");
        playlist.shuffle();
        playlist.printPlaylist();        
    }
}
