package main.java.by.vasiliuk.dto;

public class AdvertTo {
    private long id;
    private String title;
    private String text;
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdvertTo(long id, String title, String text, String username) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.username = username;
    }
}
