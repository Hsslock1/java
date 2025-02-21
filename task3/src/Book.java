import java.util.ArrayList;

public class Book {

    private int id;
    private String name;
    private ArrayList<String> authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String cover;

    private static int counter_object = 0;

    public Book() {
        this.id = counter_object++;
        this.name = "Книга";
        this.authors = new ArrayList<>();
        this.authors.add("Бондарь Владислав");
        this.publisher = "ВСГУТУ";
        this.year = 2025;
        this.pages = 100;
        this.price = 900.20;
        this.cover = "Твердый переплет — 7";
    }

    public Book(String name, ArrayList<String> authors, String publisher, int year, int pages, double price, String cover) {
        this.id = counter_object++;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return String.format("%-4s %-25s %-65s %-20s %-4s %-15s %-8s %-15s",
                id, name, GetAllAuthors(), publisher, year, pages, price, cover);
    }

    private String GetAllAuthors() {
        StringBuilder result = new StringBuilder();
        for (String author: this.authors) {
            result.append(author).append("; ");
        }
        return result.toString();
    }
}
