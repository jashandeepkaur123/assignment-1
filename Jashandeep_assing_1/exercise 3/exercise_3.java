class Order {
    String customerName;
    String drinkType;
    String size;

    public Order(String customerName, String drinkType, String size) {
        this.customerName = customerName;
        this.drinkType = drinkType;
        this.size = size;
    }
}

class Node {
    Order order;
    Node next;

    public Node(Order order) {
        this.order = order;
    }
}

class CoffeeShopQueue {
    private Node front;
    private Node rear;

    public void addOrder(Order order) {
        Node newNode = new Node(order);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void removeNextOrder() {
        if (front != null) {
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
    }

    public void printNextOrder() {
        if (front != null) {
            System.out.println("Customer Name: " + front.order.customerName +
                               ", Drink Type: " + front.order.drinkType +
                               ", Size: " + front.order.size);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class exercise_3 {
    public static void main(String[] args) {
        CoffeeShopQueue coffeeShopQueue = new CoffeeShopQueue();

        coffeeShopQueue.addOrder(new Order("John", "Latte", "Large"));
        coffeeShopQueue.addOrder(new Order("Alice", "Espresso", "Small"));
        coffeeShopQueue.addOrder(new Order("Bob", "Cappuccino", "Medium"));
        coffeeShopQueue.addOrder(new Order("Customer", "Venti", "Large"));

        coffeeShopQueue.printNextOrder();

        coffeeShopQueue.removeNextOrder();

        coffeeShopQueue.printNextOrder();

        System.out.println("Is the queue empty? " + coffeeShopQueue.isEmpty());
        coffeeShopQueue.removeNextOrder();
        coffeeShopQueue.removeNextOrder();
        coffeeShopQueue.removeNextOrder();
        System.out.println("Is the queue empty? " + coffeeShopQueue.isEmpty());
    }
}
