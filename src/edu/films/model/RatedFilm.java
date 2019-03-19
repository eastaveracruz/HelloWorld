package edu.films.model;

public class RatedFilm {

    Film film;
    String rating;

    public RatedFilm() {
    }

    public RatedFilm(Film film, String rating) {
        this.film = film;
        this.rating = rating;
    }

    public Film getBook() {
        return film;
    }

    public String getRating() {
        return rating;
    }

}
