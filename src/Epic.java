import java.util.ArrayList;

public class Epic extends Task {
    protected ArrayList<Integer> subtasks;

    public Epic(String title, String description, String status) {
        super(title, description, status);
        subtasks = new ArrayList<>();
    }

    public void addSubtask(int subId) {
        this.subtasks.add(subId);
    }

    public ArrayList<Integer> getSubIds() {
        return subtasks;
    }

    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }

    public void setSubId(ArrayList<Integer> subIds) {
        this.subtasks = subIds;
    }
}
