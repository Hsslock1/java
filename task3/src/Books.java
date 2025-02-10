import java.util.ArrayList;
import java.util.Random;

public class Books {

    // подборка значений с гугла
    private final String[] names = {
            "Дневник Анны Франк",
            "Думай и богатей",
            "Унесенные ветром",
            "Сумерки. Сага",
            "Код да Винчи",
            "Алхимик",
            "Властелин колец",
            "Гарри Поттер",
            "Цитаты Мао Цзэдун",
            "Хитроумный идальго Дон Кихот Ламанчский",
            "Лолита",
            "Десять негритят",
            "Над пропастью во ржи",
            "Энн из Зеленых крыш",
            "Повесть о двух городах",
            "Алиса в стране чудес",
            "Она",
            "Сон в красном тереме"};

    private final String[] authors = {
            "Цао Сюэцинь",
            "Генри Райдер Хаггард",
            "Льюис Кэрролл",
            "Чарльз Диккенс",
            "Люси Мод Монтгомери",
            "Джером Дэвид Сэлинджер",
            "Агата Кристи",
            "Владимир Набоков",
            "Мигель де Сервантес",
            "Мао Цзэдун",
            "Джоан Роулинг",
            "Дж. Р. Р. Толкин",
            "Пауло Коэльо",
            "Дэн Браун",
            "Стефани Майер",
            "Маргарет Митчелл",
            "Наполеон Хилл",
            "Анна Франк"};

    private final String[] publishers = {
            "Pearson",
            "Reed Elsevier",
            "ThomsonReuters",
            "Wolters Kluwer",
            "Hachette Livre",
            "Grupo Planeta",
            "McGraw–Hill Education",
            "Random House",
            "Holtzbrinck",
            "Scholastic"};

    private final String[] covers = {
            "Твердый переплет — 7",
            "Твердый переплет — 7БЦ",
            "Твердый переплет — 7Б",
            "Твердый переплет — 7Т",
            "Мягкий переплет (КБС)",
            "Мягкий переплет (ШКС)",
            "Интегральный переплет",
            "Переплет на металлическую пружину",
            "Брошюровка металлической скобой",
            "Крепление на болтах"};

    private final ArrayList<Book> books; //для фильтрации внутри класса

    public Books(int count) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (int i = 0; i < count; i++)
            result.add(new Book(GetRandomName(),
                    GetRandomAuthor(),
                    GetRandomPublisher(),
                    GetRandomYear(),
                    GetRandomPages(),
                    GetRandomPrice(),
                    GetRandomCover()));
        this.books = result;
    }

    public Books(ArrayList<Book> books) {
        this.books = books;
    }

    private int GetRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private String GetRandomName() {
        return names[GetRandom(0, names.length - 1)];
    }

    private ArrayList<String> GetRandomAuthor() {
        ArrayList<String> authors = new ArrayList<String>();
        int count_authors = GetRandom(1, 3);
        for (int i = 0; i < count_authors; i++) {
            authors.add(this.authors[GetRandom(0, this.authors.length - 1)]);
        }
        return authors;
    }

    private String GetRandomPublisher() {
        return publishers[GetRandom(0, publishers.length - 1)];
    }

    private int GetRandomYear() {
        return GetRandom(1900, 2025);
    }

    private int GetRandomPages() {
        return GetRandom(10, 1000);
    }

    private double GetRandomPrice() {
        // сначала случайное число, потом к нему копейки
        return GetRandom(400, 10000) + (double) GetRandom(1, 100) /100;
    }

    private String GetRandomCover() {
        return covers[GetRandom(0, covers.length - 1)];
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> FilterByYear(int min_year, int max_year) {
        ArrayList<Book> filtered_books = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getYear() < max_year && book.getYear() > min_year)
                filtered_books.add(book);
        }
        return filtered_books;
    }

    public ArrayList<Book> FilterByPrice(int min_price, int max_price) {
        ArrayList<Book> filtered_books = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getPrice() < max_price && book.getPrice() > min_price)
                filtered_books.add(book);
        }
        return filtered_books;
    }

    public ArrayList<Book> SearchByAuthor(String author) {
        ArrayList<Book> filtered_books = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthors().contains(author))
                filtered_books.add(book);
        }
        return filtered_books;
    }
}
