public class CustomException extends Exception {
    public enum ErrorType {
        FILE_NOT_FOUND,
        IO_ERROR,
        INVALID_RECORD,
        INVALID_LOCALE,
        INVALID_NUMBER,
        OUT_OF_MEMORY,
        INVALID_VALUE
    }

    public CustomException(String arg, ErrorType errorType) {
        super(getErrorMessage(arg, errorType));
    }

    private static String getErrorMessage(String arg, ErrorType errorType) {
        return switch (errorType) {
            case FILE_NOT_FOUND -> "Ошибка: Файл " + arg + " не найден.";
            case IO_ERROR -> "Ошибка: Проблема с чтением файла " + arg + ".";
            case INVALID_RECORD -> "Ошибка: Некорректная запись в файле " + arg + ".";
            case INVALID_LOCALE -> "Ошибка: Некорректная локаль " + arg + ".";
            case INVALID_NUMBER -> "Ошибка: Некорректное число " + arg + ".";
            case OUT_OF_MEMORY -> "Ошибка: Недостаточно памяти для выполнения операции " + arg + ".";
            case INVALID_VALUE -> "Ошибка: Недопустимое значение числа " + arg + ".";
        };
    }
}