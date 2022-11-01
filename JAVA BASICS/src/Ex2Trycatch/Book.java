package Ex2Trycatch;

public class Book {
    int id;
    String name;
    String author;

    public Book(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return "id: " + id + ", "+ "name: " + name+ "author: " +author;
    }
}

