package classes; // класс находится в пакете "classes" вместе с остальными классами

import java.util.Objects; // для удобной работы с методами equals и hashCode

public class Island {
    private final String name; // final для неизменности

    // Конструктор класса Island, принимающий имя острова
    public Island(String name) {
        this.name = name; // Инициализируем поле name
    }

    public String getName() {
        return name;
    }

    // Переопределяем метод equals для сравнения объектов Island
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверяем, ссылаются ли ссылки на один и тот же объект
        // Проверяем, является ли объект o экземпляром Island
        if (!(o instanceof Island island)) return false;
        return Objects.equals(name, island.name); // Сравниваем имена островов
    }

    // Переопределяем метод hashCode для генерации хэш-кода объекта Island
    @Override
    public int hashCode() {
        return Objects.hash(name); // Генерируем хэш-код на основе имени острова
    }

    // Переопределяем метод toString для удобного представления объекта Island в виде строки
    @Override
    public String toString() {
        return "Остров " + name + "\n";
    }
}
