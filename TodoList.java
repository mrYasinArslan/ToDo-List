import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> items;
    private Scanner scanner;

    public TodoList() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. Display the list");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid  choice.");
                    break;
            }
        }
    }

    public void addItem() {
        System.out.println("\nEnter an item:");
        String item = scanner.nextLine();
        items.add(item);
        System.out.println(item + " added to the list.");
    }

    public void removeItem() {
        System.out.println("\nEnter the index of the item you want to remove:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid index.");
            return;
        }
        String removedItem = items.remove(index);
        System.out.println(removedItem + " removed from the list.");
    }

    public void displayList() {
        if (items.size() == 0) {
            System.out.println("\nThe list is empty.");
            return;
        }
        System.out.println("\nThe list contains:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.run();
    }
}
