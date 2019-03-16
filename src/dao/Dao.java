package dao;

import entity.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dao {

    private static List<Film> filmsList;

    static {
        filmsList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            filmsList.add(new Film("Film " + String.format("%02d", i),
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when " +
                            "an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                            "It has survived not only five centuries, but also the leap into electronic typesetting," +
                            "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset " +
                            "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software" +
                            " like Aldus PageMaker including versions of Lorem Ipsum.",
                    "./img/xmen" + String.format("%02d", i) + ".jpg"));
        }
    }

    public List<Film> getAll() {
        return filmsList;
    }

    public List<Film> getByTitle(String title) {
        return filmsList.stream().filter(f -> f.getTitle().contains(title)).collect(Collectors.toList());
    }

}
