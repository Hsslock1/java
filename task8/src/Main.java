//5.	После каждого слова текста, заканчивающегося заданной подстрокой, вста- вить указанное слово.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] input_data = getUsersInput();

        String result = insertWordAfterSubstring(input_data[0], input_data[1], input_data[2]);

        System.out.println("Измененный текст:");
        System.out.println(result);
    }

    private static String[] getUsersInput() {
        // считывание исходных данных
         Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите подстроку:");
        String substring = scanner.nextLine();

        System.out.println("Введите слово для вставки:");
        String wordToInsert = scanner.nextLine();

        return new String[]{text, substring, wordToInsert};
    }

   /* private static String[] getTestInput() {
        String text = "Это тестовая строка. Она проверяет, как слово вводится после какой-то подстроки.\n" +
                "Строка 1\n" +
                "Ещё одна строка";
        String substring = "строка";
        String wordToInsert = "ваврарврв";

        return new String[]{text, substring, wordToInsert};
    } */

    // основная функция
    private static String insertWordAfterSubstring(String text, String substring, String wordToInsert) {
        // создаем новую строку, добавляя к нужной подстроке указанное слово
        String modifiedSubstring = substring + " " + wordToInsert;
        // возвращаем текст с совершенными заменами
        return text.replace(substring, modifiedSubstring);
    }
}
