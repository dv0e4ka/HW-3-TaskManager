package manager.history;

import constructor.Task;

import java.util.List;

public interface HistoryManager<T extends Task> {
     void addHistory(T task);

     List<T> getHistory();


}
