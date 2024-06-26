import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueSet {
    public int getMaxSize() {
        return this.maxSize;
    }

    private static final int MAX_SIZE = 10;
    private int maxSize;
    private LinkedList<Task> queue = new LinkedList<>();

    /**
     * A default constructor that sets the maximum size of the queue to be 10 Tasks.
     */
    public BoundedPriorityQueSet() {
        maxSize = 10;
    }

    /**
     * A parametarized constructor.
     */
    public BoundedPriorityQueSet(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    /**
     * A method called size() that takes no parameters & returns the number of Tasks currently stored in your queue.
     *
     * @return the current size of the queue.
     */
    public int size() {
        return queue.size();
    }


    /**
     * A method called isEmpty() that takes no parameters. This should return whether there is data currently stored in the queue.
     *
     * @return true if there are no tasks in the queue, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * A method called isFull() that takes no parameters. This should return whether the queue is currently full.
     *
     * @return true if the queue size has reached its maximum capacity, false otherwise.
     */
    public boolean isFull() {
        return queue.size() == maxSize;
    }

    /**
     * This method calculates the insertion for a new task or throws an exception if it already exists.
     *
     * @param newTask The task to be checked and potentially added to the queue.
     * @return The position in the queue where the new task should be added
     * @throws DuplicateElementException if the task already exists in the queue.
     */

    private int calcPosition(Task newTask) throws DuplicateElementException {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(newTask)) {
                throw new DuplicateElementException("Task already exists in the queue");
            }
        }
        return queue.size();

    }

    /**
     * Writes all tasks currently in the queue to a specified file.
     *
     */
    public void writeTasksToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Task task : queue) {
                writer.println(task.toString());
            }
            System.out.println("Tasks successfully written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    /**
     * This method adds a new tasks to the que if space is available and theres no duplicates that exists.
     *
     * @param newTask The task to be added.
     * @throws DuplicateElementException if the task already exists in the queue.
     * @throws IllegalStateException if the queue is full.
     */
    public void add(Task newTask) throws DuplicateElementException {
        if (queue.size() == MAX_SIZE) {
            throw new IllegalStateException("Queue is full");
        }

        int position = calcPosition(newTask);
        queue.add(position, newTask);
    }

    /**
     * This method tries to add a tasks to the que, it will return true if it is successful and false if not.
     *
     * @param newTask The task to be added.
     * @return true if the task was successfully added, false if the queue was full or the task already exists.
     */
    public boolean offer(Task newTask) {
        if (queue.size() == MAX_SIZE) {
            return false;
        }

        try {
            int position = calcPosition(newTask);
            queue.add(position, newTask);
            return true;
        } catch (DuplicateElementException e) {
            return false;
        }
    }


    /**
     * This method retrieves, but doesnt remove the first element of the que.
     *
     * @return a copy of the first task in the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public Task element() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Task original = queue.get(0);
        Task copy = new Task();
        copy.setOwner(original.getOwner());
        copy.setDescription(original.getDescription());
        copy.setDeadline(original.getDeadline());
        return copy;
    }

    /**
     * This method retrieves, but doesnt remove the first element of the que nor return null if the que turns out to be empty.
     *
     * @return a copy of the first task in the queue or null if empty.
     */
    public Task peek() {
        if (queue.isEmpty()) {
            return null;
        }

        Task original = queue.get(0);
        Task copy = new Task();
        copy.setOwner(original.getOwner());
        copy.setDescription(original.getDescription());
        copy.setDeadline(original.getDeadline());
        return copy;
    }

    /**
     * This method removes and returns the first element of the que.
     *
     * @return the removed task.
     * @throws NoSuchElementException if the queue is empty.
     */
    public Task remove() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return queue.remove(0);
    }

    /**
     * This method removes and return the first element of the que nor returns null if they que turns out to be empty.
     *
     * @return the removed task, or null if the queue is empty.
     */
    public Task poll() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.remove(0);
    }

}