/*5.	Найти количество чисел, содержащих только четные цифры,
 а среди них — количество чисел с равным числом четных и нечетных цифр. */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n]; // создаем массив a с размером элементов n

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt(); // заполнение массива
        }

        int evenNumbers = 0; // только четные числа
        int evenAndNoEvenNumbers = 0; // только равное количество четных и нечетных чисел
        String numberStr;

        for (int i = 0; i < a.length; i++) {
            numberStr = String.valueOf(a[i]);  // Преобразуем число в строку
            /* Вызов функции для проверки четности всех цифр в числе*/
            if (isAllEvenNumbers(numberStr)) {
                evenNumbers++;
                /* иначе подсчитываем в оставшихся числах количество четных и нечетных цифр
                * и, если они равны, увеличиваем другой счетчик*/
            } else if (getEvenNumbers(numberStr) == getNoEvenNumbers(numberStr)) {
                evenAndNoEvenNumbers++;
            }
        }
        System.out.println("Количество чисел, состоящих только из четных цифр: " + evenNumbers);
        System.out.println("Количество чисел, с равным количеством четных и нечетных цифр: " + evenAndNoEvenNumbers);
        System.out.println("\n***********************************\n");
        System.out.println("Разработчик: Владислав Бондарь");
        System.out.println("Задание получено: 04.02.2025");
        System.out.println("Задание выполнено: 07.02.2025");
    }

    public static boolean isAllEvenNumbers(String numberStr) {
        char numberChar;
        int number;
        // проходим по каждому символу из полученной строки
        for (int i = 0; i < numberStr.length(); i++) {
            numberChar = numberStr.charAt(i); //  CharAt - берем символ из строки
            // преобразуем этот символ в цифру
            number = Character.getNumericValue(numberChar); // Character - встроенный класс
            // GetNumericValue - метод из класса Character для преобразования из char в int.
            // если цифра нечетная, возвращаем false
            if (number % 2 != 0) {
                return false;
            }
        }
        // если до этого функция не завершилась
        // значит все цифры четные
        return true;
    }
// Функция для подсчета четных чисел
    public static int getEvenNumbers(String numberStr) {
        int result = 0;
        char numberChar;
        int number;
        for (int i = 0; i < numberStr.length(); i++) {
            numberChar = numberStr.charAt(i);
            number = Character.getNumericValue(numberChar);
            // подсчет четных цифр
            if (number % 2 == 0) {
                result++;
            }
        }
        return result;
    }
    // Функция для подсчета нечетных чисел
    public static int getNoEvenNumbers(String numberStr) {
        int result = 0;
        char numberChar;
        int number;
        for (int i = 0; i < numberStr.length(); i++) {
            numberChar = numberStr.charAt(i);
            number = Character.getNumericValue(numberChar);
            // подсчет нечетных
            if (number % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}