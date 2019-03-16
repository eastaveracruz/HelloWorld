package edu.films.service;

import java.util.HashMap;
import java.util.Map;

import edu.films.model.Book;
import edu.films.model.User;

/**
 *
 */
public class RatingService {

    //-------------- singleton
    static RatingService instance = new RatingService();

    private RatingService() {
    }

    public static RatingService getInstance() {
        return instance;
    }
    //--------------

    private Map<User, Map<Book, String>> ratingMap = new HashMap<>();

    public boolean rate(String id, String rating) {
        return false;
    }

    public boolean rateBook(User user, String bookId, String rating) {
        //TODO if not found
        Book book = BookService.getInstance().getBookById(bookId);
        setRating(book, user, rating);
        return true;
    }

    public boolean rateFilm(String id, String rating) {
        return false;
    }


    public String getRating(Book book, User user) {
        Map<Book, String> bookMap = ratingMap.computeIfAbsent(user, k -> new HashMap<>());
        String rating = bookMap.get(book);
        return rating;
    }

    private void setRating(Book book, User user, String rating) {
        Map<Book, String> bookMap = ratingMap.computeIfAbsent(user, k -> new HashMap<>());
        bookMap.put(book, rating);
    }
}
