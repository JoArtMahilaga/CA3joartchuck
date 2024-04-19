import java.util.LinkedList;

public class BoundedPriorityQueSet {

   private int maxSize;
   private LinkedList<Task> queue = new LinkedList<>();

    //A default constructor that sets the maximum size of the queue to be 10 Tasks.
    public BoundedPriorityQueSet() {
maxSize = 10;
    }


    public BoundedPriorityQueSet(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    //A method called size() that takes no parameters & returns the number of Tasks currently stored in your queue.
    public int size() {
        return queue.size();
    }

    //A method called isEmpty() that takes no parameters. This should return whether there is data currently stored
    //in the queue.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    //A method called isFull() that takes no parameters. This should return whether the queue is currently full.
    public boolean isFull() {
        return queue.size() == maxSize;
    }


}
