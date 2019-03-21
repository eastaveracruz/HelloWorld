package edu.films.service;

import edu.films.model.Film;
import edu.films.model.RatedFilm;
import edu.films.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmService {

    static FilmService instance = new FilmService();

    private static List<Film> filmsList;

    public static FilmService getInstance() {
        return instance;
    }

    static {
        filmsList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            filmsList.add(new Film(i, "Film " + String.format("%02d", i),
                    "./resources/films_img/xmen" + String.format("%02d", i) + ".jpg",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when " +
                            "an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                            "It has survived not only five centuries, but also the leap into electronic typesetting," +
                            "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset " +
                            "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software" +
                            " like Aldus PageMaker including versions of Lorem Ipsum."
            ));
        }
    }

    public List<Film> getAll() {
        return filmsList.stream().sorted().collect(Collectors.toList());
    }

    public List<RatedFilm> getByTitle(String title) {
        return filmsList.stream().filter(f -> f.getTitle().contains(title)).map(book -> new RatedFilm(book, null)).collect(Collectors.toList());
    }

    public List<RatedFilm> getByTitle(String title, User user) {
        return filmsList.stream().filter(f -> f.getTitle().contains(title)).map(book -> new RatedFilm(book, RatingService.getInstance().getRating(book, user))).collect(Collectors.toList());
    }


    public boolean add(Film film) {
        return  filmsList.add(film);
    }

    public List<RatedFilm> getRatedFilm(User user) {
        return getAll().stream().map(book -> new RatedFilm(book, RatingService.getInstance().getRating(book, user))).collect(Collectors.toList());

    }

    public List<RatedFilm> getRatedFilm() {
        return getAll().stream().map(book -> new RatedFilm(book, null)).collect(Collectors.toList());
    }

    public Film getFilmById(Integer bookId) {
        List<Film> books = getAll();
        Optional<Film> first = books.stream().filter(book -> book.getId() == bookId).findFirst();
        return first.orElseThrow(() -> new IllegalArgumentException("book not found with id " + bookId));
    }

    public boolean delete(int id) {
        Optional<Film> first = filmsList.stream().filter(film -> film.getId() == id).findFirst();
        return filmsList.remove(first.orElse(new Film()));
    }
}
