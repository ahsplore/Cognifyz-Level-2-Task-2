import java.util.*;

class Task {
    int id;
    String name;
    String description;
    boolean completed;

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    @Override
    public String toString() {
        return "[" + (completed ? "✔" : " ") + "] Task ID: " + id + " | Name: " + name + " | Description: " + description;
    }
}

public class ToDoApp {
    List<Task> tasks;
    int nextId;

    public ToDoApp() {
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void createTask(String name, String description) {
        tasks.add(new Task(nextId++, name, description));
        System.out.println("\n✨ Task created successfully!");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\n🚨 No tasks available. Add a task to get started!");
        } else {
            System.out.println("\n--- Your To-Do List ---");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void updateTask(int id, String newName, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setName(newName);
                task.setDescription(newDescription);
                System.out.println("\n✅ Task updated successfully!");
                return;
            }
        }
        System.out.println("\n❌ Task not found.");
    }

    public void deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("\n🗑️ Task deleted successfully!");
                return;
            }
        }
        System.out.println("\n❌ Task not found.");
    }

    public void toggleTaskCompletion(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.toggleCompleted();
                System.out.println("\n🔄 Task completion status updated!");
                return;
            }
        }
        System.out.println("\n ❌ Task not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoApp toDoApp = new ToDoApp();
        boolean isTrue = true;

        System.out.println("\n 🎉 Welcome to Your To-Do Console App! 🎉");

        while (isTrue) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update a Task");
            System.out.println("4. Remove a Task");
            System.out.println("5. Mark Task as Completed/Incomplete");
            System.out.println("6. Exit");
            System.out.print("\nChoose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();
                    toDoApp.createTask(name, description);
                    break;
                case 2:
                    toDoApp.displayTasks();
                    break;
                case 3:
                    System.out.print("\nEnter task ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter new task name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new task description: ");
                    String newDescription = sc.nextLine();
                    toDoApp.updateTask(updateId, newName, newDescription);
                    break;
                case 4:
                    System.out.print("\nEnter task ID to delete: ");
                    int deleteId = sc.nextInt();
                    toDoApp.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.print("\nEnter task ID to toggle completion: ");
                    int toggleId = sc.nextInt();
                    toDoApp.toggleTaskCompletion(toggleId);
                    break;
                case 6:
                    isTrue = false;
                    System.out.println("\n👋 Thank you for using the To-Do App. Goodbye!");
                    break;
                default:
                    System.out.println("\n❌ Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
