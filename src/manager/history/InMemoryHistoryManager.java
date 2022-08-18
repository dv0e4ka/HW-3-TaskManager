package manager.history;

import constructor.Task;
import manager.history.HistoryManager;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    public List<Task> history = new LinkedList<>();

    @Override
    public void addHistory(Task task) {
        history.add(task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }

    @Override
    public List<Task> getHistory() {
        return history;
    }
}
