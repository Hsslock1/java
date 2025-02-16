import java.io.BufferedReader; // для чтения текстовых данных из потока
import java.io.FileReader; // для чтения данных из файла
import java.io.FileNotFoundException; // исключение для обработки отсутствия файла
import java.io.IOException; // исключение для обработки ошибок ввода-вывода
import java.util.ArrayList; // динамический массив
import java.util.List; // для работы со списками
import java.util.Locale; // для работы с локалями

public class Main {
    // метод для чтения чисел с плавающей точкой из файла
    public static List<Double> readFloatingPointNumbers(String filePath) throws CustomException {
        List<Double> numbers = new ArrayList<>(); // создание списка для хранения чисел
        // открытие файла для чтения
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; // строка
            // чтение файла построчно
            while ((line = br.readLine()) != null) {
                processLine(line, numbers); // обработка каждой строки
            }
        } catch (FileNotFoundException e) { // если файл не найден
            throw new CustomException(filePath, CustomException.ErrorType.FILE_NOT_FOUND);
        } catch (IOException e) { // обработка ошибок ввода-вывода
            throw new CustomException(e.getMessage(), CustomException.ErrorType.IO_ERROR);
        } catch (OutOfMemoryError e) { // нехватка памяти
            throw new CustomException(e.getMessage(), CustomException.ErrorType.OUT_OF_MEMORY);
        }

        return numbers; // возврат списка чисел, если все хорошо
    }

    // метод для обработки строки из файла
    private static void processLine(String line, List<Double> numbers) throws CustomException {
        String[] parts = line.split(","); // разделение строки на части по запятой
        if (parts.length != 2) { // проверка на количество частей
            // выброс исключения при некорректной записи
            throw new CustomException(line, CustomException.ErrorType.INVALID_RECORD);
        }

        String numberStr = parts[0].trim(); // получение и обрезка строки с числом
        String localeStr = parts[1].trim(); // получение и обрезка строки с локалью
        parseLocale(localeStr); // проверка корректности локали
        double number = parseNumber(numberStr); // парсинг числа
        numbers.add(number); // добавление числа в список
    }

    // метод для проверки корректности локали
    private static void parseLocale(String localeStr) throws CustomException {
        Locale locale = Locale.forLanguageTag(localeStr); // создание объекта локали
        if (!isValidLocale(locale)) { // проверка на валидность локали
            // если локаль некорректна
            throw new CustomException(localeStr, CustomException.ErrorType.INVALID_LOCALE);
        }
    }

    // метод для проверки, существует ли локаль
    private static boolean isValidLocale(Locale locale) {
        // перебор всех доступных локалей из библиотеки
        for (Locale availableLocale : Locale.getAvailableLocales()) {
            if (locale.equals(availableLocale)) { // сравнение с доступными локалями
                return true; // если совпадает, возвращаем true
            }
        }
        return false; // если не совпадает, возвращаем false
    }

    // метод для парсинга числа из строки
    private static double parseNumber(String numberStr) throws CustomException {
        try { // попытка преобразовать строку в число
            double number = Double.parseDouble(numberStr);
            if (number < -1e308 || number > 1e308) { // проверка на допустимый диапазон
                // выброс исключения при выходе за диапазон
                throw new CustomException(numberStr, CustomException.ErrorType.INVALID_VALUE);
            }
            return number; // возврат числа
        } catch (NumberFormatException e) { // обработка исключения при некорректном формате числа
            throw new CustomException(numberStr, CustomException.ErrorType.INVALID_NUMBER);
        }
    }

    public static void main(String[] args) {

        // список файлов для тестирования
        String[] testFiles = {
                "task9/src/tests/valid_number.txt",      // корректные данные
                "task9/src/tests/incorrect_number.txt",     // некорректное число
                "task9/src/tests/incorrect_data.txt",     // некорректная запись
                "task9/src/tests/incorrect_local.txt",     // некорректная локаль
                "task9/src/tests/vne_diapazona.txt",       // числа вне допустимого диапазона
                "task9/src/missing_file.txt"        // файл не найден
        };

        // тестирование каждого файла путем перебора из списка файлов
        for (String filePath : testFiles) {
            // отображение текущего файла
            System.out.println("Тестирование файла: " + filePath);
            try {
                // попытка чтения чисел с плавающей точкой из файла с помощью разработанного метода
                List<Double> numbers = readFloatingPointNumbers(filePath);
                // вычисление суммы всех чисел в списке, если все было удачно
                double totalSum = numbers.stream().mapToDouble(Double::doubleValue).sum();
                // вычисление среднего значения, если список не пустой
                double average = numbers.isEmpty() ? 0 : totalSum / numbers.size();

                System.out.println("Сумма: " + totalSum);
                System.out.println("Среднее значение: " + average);
            } catch (CustomException e) { // обработка исключений, выбрасываемых при чтении файла
                System.out.println(e.getMessage()); // вывод сообщения об ошибке
            }
            System.out.println(); // пустая строка для разделения выводов между тестами
        }

    }
}