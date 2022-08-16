package manager;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import constructor.*;

public class Manager {
    private int nextId = 1;
    public Map<Integer, Task> tasks = new HashMap<>();
    public Map<Integer, Epic> epics = new HashMap<>();
    public Map<Integer, Subtask> subtasks = new HashMap<>();

    public void add(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void add(Subtask subtask) {
        subtask.setId(nextId++);
        subtasks.put(subtask.getId(), subtask);
    }

    public void add(Epic epic) {
        epic.setId(nextId++);
        updateEpicStatus(epic);
        epics.put(epic.getId(), epic);
    }

    public List<List> getAllTasksList() {
        List<List> listAllTask = new ArrayList<List>();
        listAllTask.add(getEpicValues());
        listAllTask.add(getSubtaskValues());
        listAllTask.add(getTaskValues());
        return listAllTask;
    }

    public List<Task> getTaskValues() {
        return new ArrayList<>(tasks.values());
    }

    public List<Subtask> getSubtaskValues() {
        return new ArrayList<>(subtasks.values());
    }

    public List<Epic> getEpicValues() {
        return new ArrayList<>(epics.values());
    }

    public Task getById(Task idTask) {
        return tasks.get(idTask);
    }

    public Subtask getById(Subtask idSubTask) {
        return subtasks.get(idSubTask);
    }

    public Epic getById(Epic idEpic) {
        return epics.get(idEpic);
    }

    public void removeById(int id) {
        if (tasks.containsKey(id)) removeTask(id);
        if (subtasks.containsKey(id)) removeSubtask(id);
        if (epics.containsKey(id)) removeEpic(id);
    }

    private void removeTask(int id) {
        tasks.remove(id);
    }

    public void removeSubtask(int id) {
        subtasks.remove(id);
    }

    public void removeEpic(int id) {
        epics.remove(id);
    }

    public void deleteAllTasks() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public void update(Task task) {
        tasks.put(task.getId(), task);
    }

    private void update(Subtask subtask) {
        subtasks.put(subtask.getEpicId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        updateEpicStatus(epic);
    }

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

    public List<Subtask> getSubtaskListFromEpic(int id) {
        List<Integer> subtaskIdList = new ArrayList<>(epics.get(id).getSubtasks());
        List<Subtask> subtasksListFromEpic = new ArrayList<>();
        for (int idSub : subtaskIdList) {
            subtaskIdList.add(idSub);
        }
        return subtasksListFromEpic;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "tasks=" + tasks +
                ", epics=" + epics +
                ", subtasks=" + subtasks +
                '}';
    }
}