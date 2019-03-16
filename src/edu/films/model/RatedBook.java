package edu.films.model;

/**
 *
 */
public class RatedBook {
    Book book;
    String rating;

    public RatedBook(Book book, String rating) {
        this.book = book;
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public String getRating() {
        return rating;
    }
}
