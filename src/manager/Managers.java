package manager;

import manager.history.HistoryManager;
import manager.history.InMemoryHistoryManager;
import manager.task.InMemoryTaskManager;
import manager.task.TaskManager;

public class Managers {
    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static TaskManager getDefaultTask() {
        return new InMemoryTaskManager();
    }
}
