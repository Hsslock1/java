@FunctionalInterface
interface StringComparator {
    String compare(String str1, String str2);
}

public class Main {
    public static void main(String[] args) {
        // Реализация интерфейса с помощью лямбда-выражения
        // в скобках аргументы лямбда-выражения (параметры функции)
        // потом тело функции, то есть его основная логика, выраженная через тернарный оператор
        // который возвращает большую по длине строку
        StringComparator longerString = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;

        // Примеры использования
        String result1 = longerString.compare("Hello", "World");
        String result2 = longerString.compare("123", "Bondar Vlad");

        System.out.println(result1);
        System.out.println(result2);
    }
}