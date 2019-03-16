package edu.films.model;

/**
 *
 */
public class Film {
    private final String id;
    private final String name;
    private final String genre;

    public Film(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getId() {
        return id;
    }
}
