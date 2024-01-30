import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}

class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).markAsCompleted();
            System.out.println("Task marked as completed: " + tasks.get(index - 1).getDescription());
        } else {
            System.out.println("Invalid task index");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= Todo List Menu ======");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a task: ");
                    String taskDescription = scanner.nextLine();
                    Task newTask = new Task(taskDescription);
                    todoList.addTask(newTask);
                    System.out.println("Task added successfully");
                    break;
                case 2:
                    todoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as complete: ");
                    int taskIndex = scanner.nextInt();
                    todoList.markTaskAsCompleted(taskIndex);
                    break;
                case 4:
                    System.out.println("Exiting Todo List. Goodbye");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
