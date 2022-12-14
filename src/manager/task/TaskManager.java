package manager.task;

import constructor.*;
import manager.history.InMemoryHistoryManager;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    Map<Integer, Task> getTasks();
    Map<Integer, Epic> getEpics();
    Map<Integer, Subtask> getSubtasks();

    public void add(Task task);

    public void add(Subtask subtask);

    public void add(Epic epic);

    public List<List> getAllTasksList();

    public List<Task> getTaskValues();

    public List<Subtask> getSubtaskValues();

    public List<Epic> getEpicValues();

    public Task getTaskById(int id);

    public Subtask getSubtaskById(int id);

    public Epic getEpicById(int id);

    public void removeById(int id);

    public void removeTask(int id);

    public void removeSubtask(int id);

    public void removeEpic(int id);

    public void deleteAllTasks();

    public void update(Task task);

    public void update(Subtask subtask);

    public void update(Epic epic);

    public List<Subtask> getSubtaskListFromEpic(int id);

    public List<Task> getHistory();

    public InMemoryHistoryManager getHistoryManager();
}
