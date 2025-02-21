/*Создать классы, спецификации которых приведены ниже. Определить кон- структоры и методы setТип(), getТип(),
toString(). Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных
и вывести эти данные на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько
конструкторов.
5.	Book: id, Название, Автор(ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
Создать массив объектов. Вывести:
a)	список книг заданного автора;
b)	список книг, выпущенных заданным издательством;
c)	список книг, выпущенных после заданного года. */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printArray(ArrayList<Book> books) {
        System.out.println("Список книг:");
        System.out.printf("%-4s %-25s %-65s %-20s %-4s %-15s %-8s %-15s%n",
                "id", "Название", "Автор(ы)", "Издательство", "Год", "Кол-во страниц", "Цена", "Тип переплета");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Books books = new Books(10);
        ArrayList<Book> list_books = books.getBooks();
        int min, max;
        printArray(list_books);

        // первая книга и её первый автор
        String firstAuthor = list_books.getFirst().getAuthors().getFirst();
        System.out.println("\n-----------------------");
        System.out.println("Фильтр по автору " + firstAuthor + ":");
        System.out.println("-----------------------");
        ArrayList<Book> resultFilter = books.SearchByAuthor(firstAuthor);
        printArray(resultFilter);

        System.out.println("\n-----------------------");
        System.out.println("Фильтр по цене");
        System.out.print("Минимальная цена: ");
        min = input.nextInt();
        System.out.print("Максимальная цена: ");
        max = input.nextInt();
        System.out.println("-----------------------");
        resultFilter = books.FilterByPrice(min, max);
        printArray(resultFilter);

        System.out.println("\n-----------------------");
        System.out.println("Фильтр по году");
        System.out.print("Минимальный год: ");
        min = input.nextInt();
        System.out.print("Максимальный год: ");
        max = input.nextInt();
        System.out.println("-----------------------");
        resultFilter = books.FilterByYear(min, max);
        printArray(resultFilter);
    }
}