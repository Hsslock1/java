import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {
    private String name;
    // карта, хранящая должности и соответствующие им объекты Position
    // аналог словаря в питоне
    private final Map<String, Position> positions;

    // конструктор класса Department, инициализирует название отдела и карту должностей
    public Department(String name) {
        this.name = name;
        this.positions = new HashMap<>();
    }

    // метод для добавления новой должности в отдел
    public void addPosition(String positionName) {
        positions.put(positionName, new Position(positionName));
    }

    // метод для добавления сотрудника к указанной должности
    public void addEmployeeToPosition(String positionName, String employeeName) {
        Position position = positions.get(positionName); // получение должности по имени
        if (position != null) {
            position.addEmployee(employeeName); // добавление сотрудника к должности
        } else { // сообщение об ошибке, если должность не найдена
            System.out.println("Должность " + "\""+ positionName + "\"" + " не найдена.");
        }
    }

    // для вывода всех сотрудников по должностям
    public void printEmployees() {
        for (Position position : positions.values()) { // Перебор всех должностей
            System.out.println(position.getName() + "и:"); // Вывод названия должности (в мн. числе)
            System.out.println(position.getEmployees()); // Вывод списка сотрудников
        }
    }

    // геттер для получения названия отдела
    public String getName() {
        return name;
    }

    // сеттер для изменения названия отдела
    public void setName(String name) {
        this.name = name;
    }

    // вложенный класс Position представляет собой должность с сотрудниками
    public static class Position {
        private final String name;
        private final List<String> employees;

        // конструктор класса Position, инициализирует название должности и список сотрудников
        public Position(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        // геттер для получения названия должности
        public String getName() {
            return name;
        }

        // метод для добавления сотрудника к должности
        public void addEmployee(String employeeName) {
            employees.add(employeeName);
        }

        // метод для получения списка сотрудников в виде строки без скобок
        public String getEmployees() {
            // объединение элементов списка в строку, разделенных запятой и пробелом
            return String.join(", ", employees);
        }

    }
}
