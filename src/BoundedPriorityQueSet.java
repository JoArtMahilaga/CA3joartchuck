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
    }
}
