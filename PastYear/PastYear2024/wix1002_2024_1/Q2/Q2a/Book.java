package wix1002_2024_1.Q2.Q2a;

public class Book {
    private String title;
    private String author;
    private Integer yearPublished;

    public Book(String title, String author, Integer yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Year Published: %d",
                title, author, yearPublished);
    }

}
