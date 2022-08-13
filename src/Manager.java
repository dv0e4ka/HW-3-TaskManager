import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {
    private int nextId = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

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

    public ArrayList<Task> getTaskValues() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Subtask> getSubtaskValues() {
        return new ArrayList<>(subtasks.values());
    }

    public ArrayList<Epic> getEpicValues() {
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
        epic.setStatus("NEW");
        List<Integer> subtasksId = epic.getSubIds();
        for (int id : subtasksId) {
            if (subtasks.get(id).getStatus().equals("DONE")) {
                epic.setStatus("Done");
                break;
            } else if (subtasks.get(id).getStatus() .equals("IN_PROGRESS")) {
                epic.setStatus("IN_PROGRESS");
                return;
            } else if (epic.getStatus().equals("DONE") && subtasks.get(id).getStatus().equals("NEW")) {
                epic.setStatus("IN_PROGRESS");
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