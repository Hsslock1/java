//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        int evenDigitsValuesCount = 0;
        int countEvenAndUnEvenDigits = 0;
        String numberStr;
        for (int i = 0; i < a.length; i++) {
            numberStr = String.valueOf(a[i]);  // Преобразуем число в строку
            /* Вызов функции для проверки четности всех цифр в числе*/
            if (isAllEvenDigits(numberStr)) {
                evenDigitsValuesCount++;
                /* иначе подсчитываем в оставшихся числах количество четных и нечетных цифр
                * и, если они равны, увеличиваем другой счетчик*/
            } else if (getEvenDigitsCount(numberStr) == getUnevenDigitsCount(numberStr)) {
                countEvenAndUnEvenDigits++;
            }
        }
        System.out.println("Количество чисел, состоящих из только из четных цифр: " + evenDigitsValuesCount);
        System.out.println("Количество чисел, с равным количеством четных и нечетных чисел: " + countEvenAndUnEvenDigits);
        System.out.println("\n***********************************\n");
        System.out.println("Разработчик: Владислав Бондарь");
        System.out.println("Задание получено: ??.??.202?");
        System.out.println("Задание выполнено: 07.02.2025");
    }

    public static boolean isAllEvenDigits(String numberStr) {
        char digitChar;
        int digit;
        // проходим по каждому символу из полученной строки
        for (int i = 0; i < numberStr.length(); i++) {
            digitChar = numberStr.charAt(i);
            // преобразуем этот символ в цифру
            digit = Character.getNumericValue(digitChar);
            // если цифра нечетная, возвращаем false
            if (digit % 2 != 0) {
                return false;
            }
        }
        // если до этого функция не завершилась
        // значит все цифры четные
        return true;
    }

    public static int getEvenDigitsCount(String numberStr) {
        int result = 0;
        char digitChar;
        int digit;
        for (int i = 0; i < numberStr.length(); i++) {
            digitChar = numberStr.charAt(i);
            digit = Character.getNumericValue(digitChar);
            // подсчет четных цифр
            if (digit % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static int getUnevenDigitsCount(String numberStr) {
        int result = 0;
        char digitChar;
        int digit;
        for (int i = 0; i < numberStr.length(); i++) {
            digitChar = numberStr.charAt(i);
            digit = Character.getNumericValue(digitChar);
            // подсчет нечетных
            if (digit % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}