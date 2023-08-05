import java.util.LinkedList;

import java.util.Queue;



class Athlete {

    String name;

    int age;

    int runningDistanceEachDay;



    public Athlete(String name, int age, int runningDistanceEachDay) {

        this.name = name;

        this.age = age;

        this.runningDistanceEachDay = runningDistanceEachDay;

    }

}



class QueueManager {

    private Queue<Athlete> queue;



    public QueueManager() {

        queue = new LinkedList<>();

    }



    public void enqueue(Athlete athlete) {

        queue.add(athlete);

    }



    public Athlete dequeue() {

        return queue.poll();

    }



    public boolean isEmpty() {

        return queue.isEmpty();

    }



    public int size() {

        return queue.size();

    }



    public Athlete peek() {

        return queue.peek();

    }

    public void displayAthletes(){
        Queue<Athlete> q = queue;
        
        System.out.println("The Athletes present in the queue: ");
        while(!q.isEmpty()){
            System.out.println(q.poll().name);
        }
    }

}

public class athleteQueue {

    public static void main(String[] args) {

        QueueManager athleteQueue = new QueueManager();

        Athlete athlete1 = new Athlete("Athlete 1", 25, 10);
        Athlete athlete2 = new Athlete("Athlete 2", 30, 8);
        Athlete athlete3 = new Athlete("Athlete 3", 25, 9);
        Athlete athlete4 = new Athlete("Athlete 4", 30, 10);
        Athlete athlete5 = new Athlete("Athlete 5", 25, 7);
        Athlete athlete6 = new Athlete("Athlete 6", 30, 9);
        Athlete athlete7 = new Athlete("Athlete 7", 25, 11);
        Athlete athlete8 = new Athlete("Athlete 8", 30, 8);
        Athlete athlete9 = new Athlete("Athlete 9", 25, 10);
        Athlete athlete0 = new Athlete("Athlete 0", 30, 9);
        
        athleteQueue.enqueue(athlete1);
        athleteQueue.enqueue(athlete2);
        athleteQueue.enqueue(athlete3);
        athleteQueue.enqueue(athlete4);
        athleteQueue.enqueue(athlete5);
        athleteQueue.enqueue(athlete6);
        athleteQueue.enqueue(athlete7);
        athleteQueue.enqueue(athlete8);
        athleteQueue.enqueue(athlete9);
        athleteQueue.enqueue(athlete0);

        System.out.println("Queue size: " + athleteQueue.size());

        Athlete dequeuedAthlete = athleteQueue.dequeue();
        System.out.println("Dequeued athlete: " + dequeuedAthlete.name);

        System.out.println("Is queue empty? " + athleteQueue.isEmpty());

        Athlete frontAthlete = athleteQueue.peek();
        System.out.println("Front athlete: " + frontAthlete.name);

        Athlete dequeuedAthlete2 = athleteQueue.dequeue();
        System.out.println("Dequeued athlete: " + dequeuedAthlete2.name);

        System.out.println("Is queue empty? " + athleteQueue.isEmpty());

        athleteQueue.displayAthletes();

    }

}

// This implementation provides all the standard Java Queue methods (enqueue, dequeue, isEmpty, size, and peek) to manage the queue of Athlete objects. Again, depending on your specific requirements, you may need to add additional functionality or error handling to the AthleteQueue class.