package edu.films.service;

import edu.films.model.Book;
import edu.films.model.RatedBook;
import edu.films.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public class BookService {
    //-------------- singleton
    static BookService instance = new BookService();

    private BookService() {
    }

    public static BookService getInstance() {
        return instance;
    }
    //--------------

    private List<Book> books;

    public List<RatedBook> getRatedBook(User user) {
        return getBooks().stream().map(book -> new RatedBook(book, RatingService.getInstance().getRating(book, user))).collect(Collectors.toList());
    }

    public List<RatedBook> getRatedBook(User user, Filter filter) {
        return getBooks().stream().map(book -> new RatedBook(book, RatingService.getInstance().getRating(book, user)))
                .filter(filter::satisfy)
                .collect(Collectors.toList());
    }

    public List<RatedBook> getRatedBook() {
        return getBooks().stream().map(book -> new RatedBook(book, null)).collect(Collectors.toList());
    }


    public List<Book> getBooks() {
        if (books == null) {
            books = initBooks();
        }
        System.out.println("return books: " + books.size());
        return books;
    }

    private List<Book> initBooks() {
        final List<Book> list = new ArrayList<Book>();
        list.add(new Book("1", "Harry Potter", "J.Rolling"));
        list.add(new Book("2", "Peter Pan", "J.M. Barrie"));
        list.add(new Book("3", "The Old Man and the Sea", "Ernest Hemmingway"));
        list.add(new Book("4", "The Lord of the Rings Trilogy ", "J.R.R. Tolkien"));
        list.add(new Book("5", "The Count of Monte Cristo ", "Alexandre Dumas"));
        list.add(new Book("6", "The Little Prince ", "Antoine de Saint-Exupery"));
        list.add(new Book("7", "The Alchemist", "Paulo Coelho"));
        list.add(new Book("8", "The Great Gatsby ", "Sc.Fitzgerald"));
        return list;
    }

    public Book getBookById(String bookId) {
        List<Book> books = getBooks();
        Optional<Book> first = books.stream().filter(book -> book.getId().equals(bookId)).findFirst();
        return first.orElseThrow(() -> new IllegalArgumentException("book not found with id " + bookId));
    }

}
