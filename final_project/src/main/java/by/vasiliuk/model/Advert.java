package main.java.by.vasiliuk.model;

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
}
