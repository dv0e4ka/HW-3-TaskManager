package manager.history;

import java.util.*;
import constructor.Task;

public class InMemoryHistoryManager<T extends Task> implements HistoryManager {
    public List<T> history = new LinkedList<>();

    @Override
    public void addHistory(Task task) {
        history.add((T) task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }

    @Override
    public List<T> getHistory() {
        return history;
    }
}
