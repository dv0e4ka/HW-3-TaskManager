package manager.task;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import constructor.*;
import manager.Managers;
import manager.history.InMemoryHistoryManager;


public class InMemoryTaskManager implements TaskManager {
    private static int id = 0;
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final Map<Integer, Subtask> subtasks = new HashMap<>();

    InMemoryHistoryManager historyManager = Managers.getDefaultHistory();

    public Map<Integer, Task> tasks() {
        return tasks;
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Epic> epics() {
        return epics;
    }

    public Map<Integer, Subtask> subtasks() {
        return subtasks;
    }

    @Override
    public void add(Task task) {
        task.setId(++id);
        tasks.put(task.getId(), task);
    }

    @Override
    public void add(Subtask subtask) {
        subtask.setId(++id);
        subtasks.put(subtask.getId(), subtask);
    }

    @Override
    public void add(Epic epic) {
        epic.setId(++id);
        updateEpicStatus(epic);
        epics.put(epic.getId(), epic);
    }

    @Override
    public List<List> getAllTasksList() {
        List<List> listAllTask = new ArrayList<List>();
        listAllTask.add(getEpicValues());
        listAllTask.add(getSubtaskValues());
        listAllTask.add(getTaskValues());
        return listAllTask;
    }

    @Override
    public List<Task> getTaskValues() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Subtask> getSubtaskValues() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public List<Epic> getEpicValues() {
        return new ArrayList<>(epics.values());
    }


    @Override
    public Task getTaskById(int id) {
        historyManager.addHistory(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public Subtask getSubtaskById(int id) {
        historyManager.addHistory(subtasks.get(id));
        return subtasks.get(id);
    }

    @Override
    public Epic getEpicById(int id) {
        historyManager.addHistory(epics.get(id));
        return epics.get(id);
    }

    @Override
    public void removeById(int id) {
        if (tasks.containsKey(id)) removeTask(id);
        if (subtasks.containsKey(id)) removeSubtask(id);
        if (epics.containsKey(id)) removeEpic(id);
    }

    @Override
    public void removeTask(int id) {
        tasks.remove(id);
    }

    @Override
    public void removeSubtask(int id) {
        subtasks.remove(id);
    }

    @Override
    public void removeEpic(int id) {
        epics.remove(id);
    }

    @Override
    public void deleteAllTasks() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    @Override
    public void update(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void update(Subtask subtask) {
        subtasks.put(subtask.getEpicId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        updateEpicStatus(epic);
    }

    @Override
    public void update(Epic epic) {
        tasks.put(epic.getId(), epic);
        updateEpicStatus(epic);
    }

    private void updateEpicStatus(Epic epic) {
        epic.setStatus(TaskStatus.NEW);
        List<Integer> subtasksId = epic.getSubIds();
        for (int id : subtasksId) {
            if (subtasks.get(id).getStatus().equals(TaskStatus.DONE)) {
                epic.setStatus(TaskStatus.DONE);
                break;
            } else if (subtasks.get(id).getStatus() .equals(TaskStatus.IN_PROGRESS)) {
                epic.setStatus(TaskStatus.IN_PROGRESS);
                return;
            } else if (epic.getStatus().equals(TaskStatus.DONE) && subtasks.get(id).getStatus().equals(TaskStatus.NEW)) {
                epic.setStatus(TaskStatus.IN_PROGRESS);
                return;
            }
        }
    }

    @Override
    public List<Subtask> getSubtaskListFromEpic(int id) {
        List<Integer> subtaskIdList = new ArrayList<>(epics.get(id).getSubtasks());
        List<Subtask> subtasksListFromEpic = new ArrayList<>();
        for (int idSub : subtaskIdList) {
            subtaskIdList.add(idSub);
        }
        return subtasksListFromEpic;
    }


    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    @Override
    public InMemoryHistoryManager getHistoryManager() {
        return historyManager;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}