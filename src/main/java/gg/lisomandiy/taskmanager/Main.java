package gg.lisomandiy.taskmanager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Название: ");
                    String title = scanner.nextLine();
                    manager.addTask(title);
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    System.out.print("ID задачи: ");
                    int completeId = parseIntSafe(scanner.nextLine());
                    manager.completeTask(completeId);
                    break;
                case "4":
                    System.out.print("ID задачи: ");
                    int removeId = parseIntSafe(scanner.nextLine());
                    manager.removeTask(removeId);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }

        scanner.close();
    }

    private static int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Добавить задачу");
        System.out.println("2. Показать задачи");
        System.out.println("3. Завершить задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("0. Выход");
        System.out.print("> ");
    }
}
