package myProjects.TaskApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + description);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumberToComplete = scanner.nextInt();
                    toDoList.markTaskAsCompleted(taskNumberToComplete - 1);
                    break;
                case 3:
                    System.out.print("Enter task number to remove: ");
                    int taskNumberToRemove = scanner.nextInt();
                    toDoList.removeTask(taskNumberToRemove - 1);
                    break;
                case 4:
                    toDoList.viewTasks();
                    break;
                case 5:
                    System.out.println("Thank you for using the To-Do List application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}

