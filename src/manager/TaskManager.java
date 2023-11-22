package manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import model.Task;

public class TaskManager {
    private static Map<Long, Task> tasks = new HashMap<>();
    private static long lastTaskId = 1;
    
    public static void createTask(Task task) {
        task.setId(lastTaskId++);
        tasks.put(task.getId(), task);
    }

    public static List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public static void deleteTaskById(long taskId) {
        tasks.remove(taskId);
    }

    public static boolean isExists(long taskId) {
        return tasks.containsKey(taskId);
    }
}
