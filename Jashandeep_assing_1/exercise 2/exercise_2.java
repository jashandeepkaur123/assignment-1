// import java.security.Timestamp;
// import java.sql.Date;
// import java.sql.Time;
import java.text.SimpleDateFormat;

class WebPage {
    String url;
    String timestamp;

    public WebPage(String url, String timestamp) {
        this.url = url;
        this.timestamp = timestamp;
    }
}

class Node {
    WebPage webPage;
    Node next;

    public Node(WebPage webPage) {
        this.webPage = webPage;
    }
}

class WebPageStack {
    private Node top;

    public void addWebPage(WebPage webPage) {
        Node newNode = new Node(webPage);
        newNode.next = top;
        top = newNode;
    }

    public void removeMostRecentWebPage() {
        if (top != null) {
            top = top.next;
        }
    }

    public void printMostRecentWebPage() {
        if (top != null) {
            System.out.println("URL: " + top.webPage.url + ", Timestamp: " + top.webPage.timestamp);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class exercise_2 {
    public static void main(String[] args) {
        WebPageStack webPageStack = new WebPageStack();
        webPageStack.addWebPage(new WebPage("https://www.example.com",  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));
        webPageStack.addWebPage(new WebPage("https://www.google.com", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));
        webPageStack.addWebPage(new WebPage("https://www.stackoverflow.com", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));
        webPageStack.addWebPage(new WebPage("https://www.coda.io", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));

        webPageStack.printMostRecentWebPage();

        webPageStack.removeMostRecentWebPage();

        webPageStack.printMostRecentWebPage();

        System.out.println("Is the stack empty? " + webPageStack.isEmpty());
    }
}
