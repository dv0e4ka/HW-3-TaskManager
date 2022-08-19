import constructor.*;
import manager.Managers;
import manager.history.HistoryManager;
import manager.history.InMemoryHistoryManager;
import manager.task.InMemoryTaskManager;
import manager.task.TaskManager;

public class Main {

    public static void main(String[] args) {

        TaskManager inMemoryTaskManager = Managers.getDefaultTask();
        HistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        TaskManager task = new InMemoryTaskManager();

        Epic travel = new Epic("Поехать в Индию", "Подготовиться", TaskStatus.NEW);
        Subtask tickets = new Subtask("Билеты", "Выбрать лучший вариант", TaskStatus.DONE, 1);
        Subtask bag = new Subtask("Вещи", "Собрать чемодан", TaskStatus.NEW, 1);
        Epic car = new Epic("Машина", "ТО", TaskStatus.NEW);
        Subtask oil = new Subtask("Масло", "Поменять", TaskStatus.NEW, 2);
        Task work = new Task("Проект", "Изменить главный метод", TaskStatus.NEW);
        task.add(travel);
        task.add(tickets);
        task.add(bag);
        task.add(car);
        task.add(oil);
        task.add(work);


        inMemoryTaskManager.getTaskById(1);
        task.update(car);
        task.getTaskById(1);
        inMemoryTaskManager.getTasks();

        System.out.println(inMemoryTaskManager.getHistoryManager());
        System.out.println(inMemoryHistoryManager.getHistory());
    }
}