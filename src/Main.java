import Manager.Manager;
import TasksConstructor.*;
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Epic tourism = new Epic("Поехать в Индию", "Подготовиться", TaskStatus.NEW);
        Subtask ticket = new Subtask("Билеты", "Выбрать лучший вариант", TaskStatus.DONE, 1);
        Subtask clothes = new Subtask("Вещи", "Собрать чемодан", TaskStatus.NEW, 1);
        Epic auto = new Epic("Машина", "ТО", TaskStatus.NEW);
        Subtask oil = new Subtask("Масло", "Поменять", TaskStatus.NEW, 2);

        manager.add(tourism);
        manager.add(ticket);
        manager.add(clothes);
        manager.add(auto);
        manager.add(oil);

        System.out.println(manager);
    }
}