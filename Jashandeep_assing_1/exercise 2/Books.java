import java.util.Stack;

class Book {

    String title;

    String author;

    String isbn;



    public Book(String title, String author, String isbn) {

        this.title = title;

        this.author = author;

        this.isbn = isbn;

    }

}



class BookStack {

    private Stack<Book> stack;



    public BookStack() {

        stack = new Stack<>();

    }



    public void push(Book book) {

        stack.push(book);

    }



    public Book pop() {

        return stack.pop();

    }



    public boolean isEmpty() {

        return stack.isEmpty();

    }



    public int size() {

        return stack.size();

    }



    public Book peek() {

        return stack.peek();

    }

    public void displayTitles(){
        Stack<Book> st = stack;
        System.out.println("The Title of the Books: ");

        while(!st.isEmpty()){
            System.out.println(st.pop().title);
        }
    }

}

public class Books {

    public static void main(String[] args) {

        BookStack bookStack = new BookStack();

        Book book1 = new Book("Title 1", "Author 1", "ISBN 1");
        Book book2 = new Book("Title 2", "Author 2", "ISBN 2");
        Book book3 = new Book("Title 3", "Author 3", "ISBN 3");
        Book book4 = new Book("Title 4", "Author 4", "ISBN 4");
        Book book5 = new Book("Title 5", "Author 5", "ISBN 5");
        Book book6 = new Book("Title 6", "Author 6", "ISBN 6");
        Book book7 = new Book("Title 7", "Author 7", "ISBN 7");
        Book book8 = new Book("Title 8", "Author 8", "ISBN 8");
        Book book9 = new Book("Title 9", "Author 9", "ISBN 9");
        Book book0 = new Book("Title 0", "Author 0", "ISBN 0");

        bookStack.push(book1);
        bookStack.push(book2);
        bookStack.push(book3);
        bookStack.push(book4);
        bookStack.push(book5);
        bookStack.push(book6);
        bookStack.push(book7);
        bookStack.push(book8);
        bookStack.push(book9);
        bookStack.push(book0);

        System.out.println("Stack size: " + bookStack.size());

        Book poppedBook = bookStack.pop();
        System.out.println("Popped book: " + poppedBook.title);
        System.out.println("Stack size: " + bookStack.size());
        System.out.println("Is stack empty? " + bookStack.isEmpty());

        Book topBook = bookStack.peek();
        System.out.println("Top book: " + topBook.title);
        System.out.println("Is stack empty? " + bookStack.isEmpty());
        System.out.println("Stack size: " + bookStack.size());
        System.out.println("Popped book: " + poppedBook.title);

        bookStack.displayTitles();

    }
}