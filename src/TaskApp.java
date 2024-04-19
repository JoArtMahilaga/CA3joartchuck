import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class TaskApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TaskApp");

//On start-up, the program should use a
//random number generator to decide if it will use the risky or safe approach to managing access

        boolean riskyMethod = new Random().nextBoolean();
        System.out.println("Enter the number of tasks for the queue: ");
        int maxSize = sc.nextInt();
        sc.nextLine();

        BoundedPriorityQueSet queue = new BoundedPriorityQueSet(maxSize);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new Task");
            System.out.println("2. View the next Task");
            System.out.println("3. Mark the next Task as done (remove it)");
            System.out.println("4. View the number of Tasks remaining");
            System.out.println("5. View the space remaining in the queue");
            System.out.println("6. Exit the program");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter owner name: ");
                    String owner = sc.nextLine();
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter deadline (yyyy-mm-dd): ");
                    String dateString = sc.nextLine();
                    LocalDate deadline = LocalDate.parse(dateString);
                    Task newTask = new Task(owner, description, deadline);

                    try {
                        if (riskyMethod) {
                            queue.add(newTask);
                        } else {
                            if (!queue.offer(newTask)) {
                                System.out.println("Task could not be added (queue might be full or task already exists).");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    Task nextTask = queue.peek();
                    if (nextTask == null) {
                        System.out.println("No task is next, the queue is empty.");
                    } else {
                        System.out.println("Next task: " + nextTask);
                    }
                    break;

                case 3:
                    Task removedTask = queue.poll();
                    if (removedTask == null) {
                        System.out.println("No task to remove, the queue is empty.");
                    } else {
                        System.out.println("Task completed and removed: " + removedTask);
                        if (queue.isEmpty()) {
                            System.out.println("Congratulations, all tasks are done!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Number of tasks remaining: " + queue.size());
                    break;


                case 5:
                    System.out.println("Space remaining in the queue: " + (queue.getMaxSize() - queue.size()));
                    break;

            }

        }

    }

}
