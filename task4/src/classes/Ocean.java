package classes;

import java.util.Objects; // для удобной работы с методами equals и hashCode

public class Ocean {
    private final String name;

    public Ocean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // ссылаются ли ссылки на один и тот же объект
        if (!(o instanceof Ocean ocean)) return false; // является ли переданный объект экземпляром Ocean
        return Objects.equals(name, ocean.name); // сравнение названий океанов
    }

    // Переопределяем метод hashCode для генерации хэш-кода объекта Ocean
    @Override
    public int hashCode() {
        return Objects.hash(name); // Генерируем хэш-код на основе имени океана
    }

    // Переопределяем метод toString для удобного представления объекта Ocean в виде строки
    @Override
    public String toString() {
        return "Океан " + name + "\n";
    }
}
