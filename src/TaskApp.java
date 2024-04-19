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


        }

    }
}