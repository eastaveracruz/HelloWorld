package edu.films.service;

import edu.films.model.Book;
import edu.films.model.Film;
import edu.films.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class RatingService<T> {

    //-------------- singleton
    static RatingService instance = new RatingService();

    private RatingService() {
    }

    public static RatingService getInstance() {
        return instance;
    }
    //--------------

    private Map<User, Map<T, String>> ratingMap = new HashMap<>();

    public boolean rate(String id, String rating) {
        return false;
    }

    public boolean rateBook(User user, String bookId, String rating) {
        //TODO if not found
        Book book = BookService.getInstance().getBookById(bookId);
        setRating((T) book, user, rating);
        return true;
    }

    public boolean rateFilm(User user, String bookId, String rating) {
        //TODO if not found
        Film book = FilmService.getInstance().getFilmById(Integer.parseInt(bookId));
        setRating((T) book, user, rating);
        return true;
    }



    public boolean rateFilm(String id, String rating) {
        return false;
    }


    public String getRating(T book, User user) {
        Map<T, String> bookMap = ratingMap.computeIfAbsent(user, k -> new HashMap<>());
        String rating = bookMap.get(book);
        return rating;
    }

    private void setRating(T book, User user, String rating) {
        Map<T, String> bookMap = ratingMap.computeIfAbsent(user, k -> new HashMap<>());
        bookMap.put(book, rating);
    }
}
