package classes;

import java.util.ArrayList; // для динамических массивов
import java.util.List; // для коллекций
import java.util.Objects; // для equals и hashCode

public class Planet {
    private final String name;
    // Список для хранения материков, принадлежащих планете
    private final List<Continent> continents;

    public Planet(String name) {
        this.name = name;
        this.continents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Метод для добавления материка в список материков планеты
    public void addContinent(Continent continent) {
        continents.add(continent); // Добавляем материк в список
    }

    // Метод для получения количества материков на планете
    public int getContinentCount() {
        return continents.size(); // Возвращаем размер списка материков
    }

    // Метод для отображения информации о планете и ее материках
    public void displayInfo() {
        System.out.println("Планета: " + name); // Выводим имя планеты
        // Выводим количество материков
        System.out.println("Количество материков на ней: " + getContinentCount());
        System.out.println("Список этих материков: ");
        for (Continent continent : continents) { // Проходим по списку материков
            System.out.println(continent.getName()); // Выводим имя каждого материка
        }
    }

    // Переопределяем метод equals для сравнения объектов Planet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверяем, ссылаются ли ссылки на один и тот же объект
        if (!(o instanceof Planet planet)) return false; // Проверяем, является ли объект o экземпляром Planet
        return Objects.equals(name, planet.name); // Сравниваем имена планет
    }

    // Переопределяем метод hashCode для генерации хэш-кода объекта Planet
    @Override
    public int hashCode() {
        return Objects.hash(name); // Генерируем хэш-код на основе имени планеты
    }

    // Переопределяем метод toString для удобного представления объекта Planet в виде строки
    @Override
    public String toString() {
        return "Планета " + name + "\n";
    }
}
