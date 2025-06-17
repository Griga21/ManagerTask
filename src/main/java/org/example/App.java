package org.example;

import org.example.controller.TaskController;
import org.example.entity.Task;
import org.example.priority.Priority;
import org.example.priority.Status;
import org.example.service.TaskService;
import org.example.service.TaskServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TaskService taskService = new TaskServiceImpl();
        TaskController taskController = new TaskController(taskService);
        boolean running = true;
        while (running) {
            printMenu();
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1" -> createTask(taskController);
                case "2" -> listTasks(taskController);
                case "3" -> deleteTask(taskController);
                case "0" -> {
                    running = false;
                    System.out.println("Выход...");
                }
            }
        }
    }

    private static void listTasks(TaskController taskController) {
        List<Task> taskMap = taskController.getALL();
        for (Task t : taskMap)
            System.out.println(t.getId() + " " + t.getTitle());
    }

    private static void deleteTask(TaskController taskController) {
        System.out.println("Введите ID задачи");
        Long id = scanner.nextLong();
        taskController.deleteById(id);
    }

    private static void createTask(TaskController taskController) {
        Task task = new Task();
        System.out.println("Название задачи");
        task.setTitle(scanner.nextLine());
        System.out.println("Описание задачи");
        task.setDescription(scanner.nextLine());
        System.out.println("Задайте приорете\n 1.LOW\n 2. MEDIUM\n 3.HIGH");
        switch (scanner.nextInt()) {
            case 1 -> task.setPriority(Priority.LOW);
            case 2 -> task.setPriority(Priority.MEDIUM);
            case 3 -> task.setPriority(Priority.HIGH);
        }
        task.setStatus(Status.PROGRESS);
        taskController.add(task);
    }

    private static void printMenu() {
        System.out.println("\n--- Task Manager CLI ---");
        System.out.println("1. Создать задачу");
        System.out.println("2. Список задач");
        System.out.println("3. Удалить задачу");
        System.out.println("0. Выход");
        System.out.println("Введите команду: ");
    }
}
