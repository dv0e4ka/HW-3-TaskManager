public class Subtask extends Task {
    protected int EpicId;

    public Subtask(String title, String description, String status, int epicId) {
        super(title, description, status);
        EpicId = epicId;
    }

    public int getEpicId() {
        return EpicId;
    }

    public void setEpicId(int epicId) {
        EpicId = epicId;
    }

    public String getStatus() {
        return status;
    }
}
