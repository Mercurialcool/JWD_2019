package by.vasiliuk.project.model;

import java.util.Objects;

public class Advert {

    private long id;
    private String text;
    private String title;
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Advert(long id, String text, String title, long userId) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return id == advert.id &&
                userId == advert.userId &&
                Objects.equals(text, advert.text) &&
                Objects.equals(title, advert.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, title, userId);
    }

}
