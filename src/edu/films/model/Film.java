package edu.films.model;

public class Film implements Comparable<Film> {
    private int id;
    private String title;
    private String img;
    private String description;
    private static int n = 100;

    public Film() {
    }

    public Film(String title, String description, String img) {
        id = n++;
        this.title = title;
        this.img = img;
        this.description = description;
    }

    public Film(int id, String title, String img, String description) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Film o) {
        return this.getTitle().toLowerCase().compareTo(o.getTitle().toLowerCase());
    }
}
