package classes; // класс находится в пакете "classes"

import java.util.ArrayList; // для работы с динамическими массивами
import java.util.List; // для работы с коллекциями
import java.util.Objects; // для удобной работы с методами equals и hashCode

public class Continent {
    private final String name;
    private final List<Island> islands; // Список островов, принадлежащих материкам
    private final List<Ocean> oceans; // Список океанов, окружающих материки

    // Конструктор класса Continent только по названию материка
    public Continent(String name) {
        this.name = name;
        this.islands = new ArrayList<>();
        this.oceans = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Метод для добавления острова в список островов материка
    public void addIsland(Island island) {
        islands.add(island);
    }

    // Метод для добавления океана в список океанов материка
    public void addOcean(Ocean ocean) {
        oceans.add(ocean);
    }

    // Метод для получения количества островов на материке
    public int getIslandCount() {
        return islands.size(); // Возвращаем размер списка островов
    }

    // Метод для получения количества океанов, окружающих материк
    public int getOceanCount() {
        return oceans.size(); // Возвращаем размер списка океанов
    }

    // Переопределяем метод equals для сравнения объектов Continent
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверяем, ссылаются ли ссылки на один и тот же объект
        // Проверка на то, является объект "o" экземпляром Continent
        if (!(o instanceof Continent continent)) return false;
        return Objects.equals(name, continent.name); // Сравниваем названия материков
    }

    // Переопределяем метод hashCode для генерации хэш-кода объекта Continent
    @Override
    public int hashCode() {
        return Objects.hash(name); // Генерируем хэш-код на основе названия материка
    }

    // Переопределяем метод toString для удобного представления объекта Continent в виде строки
    @Override
    public String toString() {
        return "Континент" + name + "\n";
    }
}
