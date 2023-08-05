class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}

class Node {
    Book book;
    Node next;

    public Node(Book book) {
        this.book = book;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public void addToBeginning(Book book) {
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addToEnd(Book book) {
        Node newNode = new Node(book);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFromBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeFromEnd() {
        if (head == null || head == tail) {
            head = null;
            tail = null;
        } else {
            Node currentNode = head;
            while (currentNode.next != tail) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            tail = currentNode;
        }
    }

    public void printReverse() {
        printReverseHelper(head);
    }

    private void printReverseHelper(Node node) {
        if (node == null) {
            return;
        }
        printReverseHelper(node.next);
        System.out.println("Title: " + node.book.title + ", Author: " + node.book.author + ", Publication Year: " + node.book.publicationYear);
    }
}

public class exercise_1 {
    public static void main(String[] args) {
        LinkedList booksList = new LinkedList();

        booksList.addToEnd(new Book("Book 1", "Author 1", 2020));
        booksList.addToEnd(new Book("Book 2", "Author 2", 2018));
        booksList.addToEnd(new Book("Book 3", "Author 3", 2015));
        booksList.addToBeginning(new Book("Book 0", "Author 0", 2023));

        booksList.addToBeginning(new Book("New Book", "New Author", 2022));

        booksList.removeFromBeginning();

        booksList.removeFromEnd();

        booksList.printReverse();
    }
}
