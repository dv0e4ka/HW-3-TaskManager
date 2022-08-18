import constructor.*;
import manager.Managers;
import manager.history.HistoryManager;
import manager.history.InMemoryHistoryManager;
import manager.task.InMemoryTaskManager;
import manager.task.TaskManager;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new InMemoryTaskManager();
        TaskManager inMemoryTaskManager = Managers.getDefaultTask();
        HistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        TaskManager task = new InMemoryTaskManager();

        task.add(new Epic("Поехать в Индию", "Подготовиться", TaskStatus.NEW));
        task.add(new Subtask("Билеты", "Выбрать лучший вариант", TaskStatus.DONE, 1));
        task.add(new Subtask("Вещи", "Собрать чемодан", TaskStatus.NEW, 1));
        task.add(new Epic("Машина", "ТО", TaskStatus.NEW));
        task.add(new Subtask("Масло", "Поменять", TaskStatus.NEW, 2));

    }
}