public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Epic tourism = new Epic("Поехать в Индию", "Подготовиться", "NEW");
        Subtask ticket = new Subtask("Билеты", "Выбрать лучший вариант", "Done", 1);
        Subtask clothes = new Subtask("Вещи", "Собрать чемодан", "NEW", 1);
        Epic auto = new Epic("Машина", "ТО", "NEW");
        Subtask oil = new Subtask("Масло", "Поменять", "NEW", 2);

        manager.add(tourism);
        manager.add(ticket);
        manager.add(clothes);
        manager.add(auto);
        manager.add(oil);

        System.out.println(manager);
    }
}