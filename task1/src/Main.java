/*5. Ввести целые числа как аргументы командной строки,
подсчитать их сум- мы и произведения.
Вывести результат на консоль.  */
// Аргументы вводить через командную строку
public class Main {
    public static void main(String[] args) {
        int summ = 0;
        int proizv = 1;

        for (String arg: args) {
            int value = Integer.parseInt(arg);
            summ = summ + value;
            proizv = proizv * value;
        }

        System.out.println("Сумма = " + summ);
        System.out.println("Произведение = " + proizv);
    }
}