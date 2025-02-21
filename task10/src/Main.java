//5.	Найти в строке наибольшее число цифр, следующих подряд.
import java.io.BufferedReader; // чтение текстовых потоков
import java.io.BufferedWriter; // запись в текстовые потоки
import java.io.FileReader; // чтение из файлов
import java.io.FileWriter; // запись в файлы
import java.io.IOException; // обработка исключений ввода-вывода

public class Main {
    public static void main(String[] args) {
        String inputFile; // входной файл
        String outputFile; // выходной файл

        if (args.length >= 2) { // проверяем, переданы ли аргументы командной строки
            inputFile = args[0]; // если да, первый аргумент это имя входного файла
            outputFile = args[1]; // а второй аргумент - выходной файл
        } else {
            // если аргументы не переданы, читаем их из подготовленного файла
            try (BufferedReader reader = new BufferedReader(new FileReader("task10/src/file_paths.txt"))) {
                inputFile = reader.readLine(); // первая строка - входной файл
                outputFile = reader.readLine(); // вторая строка - выходной файл
            } catch (IOException e) { // обрабатываем исключения ввода-вывода
                System.out.println("Не удалось прочитать файл с путями. Убедитесь, что файл 'task10/src/file_paths.txt' существует и содержит пути к входному и выходному файлам.");
                return; // выход, если файл не удалось прочитать
            }
        }

        // проверка на существование файлов
        if (inputFile == null || outputFile == null) { // если имена файлов не заданы
            System.out.println("Не указаны имена входного и выходного файлов. Используйте аргументы командной строки или файл 'file_paths.txt'.");
            return;
        }

        System.out.println("Считывание данных из файла " + inputFile + " для подсчета.");
        System.out.println("Результат работы записан в файл: "+outputFile + ".");
        // создаем BufferedReader для чтения и BufferedWriter для записи в файлы
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line; // текущая строка
            String maxLine = ""; // строки с максимальным количеством цифр
            int maxCount = 0; // макс. кол-во подряд идущих цифр

            while ((line = reader.readLine()) != null) { // построчно
                // вычисляем количество подряд идущих цифр в текущей строке
                int count = maxConsecutiveDigits(line);
                if (count > maxCount) { // если текущее количество больше максимального
                    maxCount = count; // обновляем максимальное количество
                    maxLine = line; // обновляем строку с максимальным количеством цифр
                }
            }

            // записываем результаты в выходной файл
            writer.write("Строка с наибольшим количеством подряд идущих цифр: " + maxLine + "\n");
            writer.write("Количество подряд идущих цифр: " + maxCount);

        } catch (IOException e) { // обрабатываем исключения ввода-вывода
            e.printStackTrace(); // выводим стек вызовов связанных с ошибкой
        }
    }
    // метод для вычисления максимального количества подряд идущих цифр в строке
    private static int maxConsecutiveDigits(String line) {
        int maxCount = 0; // переменная для хранения максимального количества
        int currentCount = 0; // переменная для хранения текущего количества подряд идущих цифр

        for (char c : line.toCharArray()) { // перебираем каждый символ в строке
            if (Character.isDigit(c)) { // если символ является цифрой
                currentCount++; // увеличиваем текущее количество
                if (currentCount > maxCount) { // если текущее количество больше максимального
                    maxCount = currentCount; // обновляем максимальное количество
                }
            } else {
                currentCount = 0; // сбрасываем текущее количество, если символ не цифра
            }
        }
        return maxCount;
    }
}
