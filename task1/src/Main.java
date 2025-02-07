//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int summ = 0;
        int proizv = 1;

        for (String arg: args) {
            int value = Integer.parseInt(arg);
            summ += value;
            proizv *= value;
        }

        System.out.println("Сумма = " + summ);
        System.out.println("Произведение = " + proizv);
    }
}