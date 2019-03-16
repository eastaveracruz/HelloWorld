package entity;

public class Film {
    private String title;
    private String img;
    private String description;

    public Film() {
    }

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film(String title, String description, String img) {
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

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
