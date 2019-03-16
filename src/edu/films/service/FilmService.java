package edu.films.service;

import java.util.ArrayList;
import java.util.List;

import edu.films.model.Film;

/**
 *
 */
public class FilmService {
    private List<Film> films;

    public List<Film> getFilms() {
        if (films == null) {
            films = initFilms();
        }
        System.out.println("return films: " + films.size());
        return films;
    }

    private List<Film> initFilms() {
        final List<Film> list = new ArrayList<Film>();
        list.add(new Film("1", "Iron man 3", "action"));
        list.add(new Film("2", "Scary MoVie 5", "comedy"));
        list.add(new Film("3", "Pain & Gain", "comedy, action"));
        list.add(new Film("4", "The Great Gatsby ", "drama"));
        list.add(new Film("5", "Oblivion", "fantastic"));
        return list;
    }
}
