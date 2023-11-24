package manager;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;

import model.Status;
import model.Task;

public class Interface {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static int getCommand(BufferedReader consoleReader) throws IOException {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Просмотреть задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Выход");
        System.out.print("Введите номер команды: ");

        return Integer.parseInt(consoleReader.readLine());
    }

    public static void getTask(BufferedReader consoleReader) throws IOException {
        Task task = new Task();
        while (true) {
            System.out.print("Введите название задачи: ");
            String taskName = consoleReader.readLine();

            if (taskName.isBlank()) {
                System.out.println("Название не может быть пустым");
            } else {
                task.setName(taskName);
                break;
            }
        }

        System.out.print("Введите описание задачи: ");
        String taskName = consoleReader.readLine();

        task.setDescription(taskName);

        task.setStatus(Status.IN_PROGRESS);

        task.setCreationDateTime(LocalDateTime.now());

        TaskManager.createTask(task);
    }

    public static void showAllTasks() {
        List<Task> tasks = TaskManager.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Пока задач нет");
            return;
        }

        for (Task task : tasks) {
            System.out.println();
            System.out.println("Задача номер: " + task.getId());
            System.out.println("Навание задачи: " + task.getName());
            System.out.println("Описание задачи: " + task.getDescription());
            System.out.println("Статус задачи: " + task.getStatus());
            System.out.println("Задача была создана: " + task.getCreationDateTime().format(FORMATTER));
            System.out.println();
        }
    }

    public static void deleteTaskById(BufferedReader consoleReader) throws IOException {
        System.out.print("Введите номер задачи: ");
        long taskId = 0;

        while (true) {
            try {
                taskId = Long.parseLong(consoleReader.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Номер задачи может быть только целым числом");
                continue;
            }
        }

        if (!TaskManager.isExists(taskId)) {
            System.out.println("Задачи с таким номером не существует");
            return;
        }

        TaskManager.deleteTaskById(taskId);
    }
}