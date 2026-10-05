package gg.lisomandiy.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Название не может быть пустым.");
            return;
        }

        Task task = new Task(nextId, title.trim());
        tasks.add(task);
        nextId++;
        System.out.println("Задача добавлена: " + task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {
        Optional<Task> found = findTask(id);
        if (found.isEmpty()) {
            System.out.println("Задача с id " + id + " не найдена.");
            return;
        }

        found.get().markDone();
        System.out.println("Задача #" + id + " отмечена выполненной.");
    }

    public void removeTask(int id) {
        Optional<Task> found = findTask(id);
        if (found.isEmpty()) {
            System.out.println("Задача с id " + id + " не найдена.");
            return;
        }

        tasks.remove(found.get());
        System.out.println("Задача #" + id + " удалена.");
    }

    private Optional<Task> findTask(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }
}
