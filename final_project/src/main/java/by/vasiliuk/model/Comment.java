package main.java.by.vasiliuk.model;

public class Comment {

    private long id;
    private String text;
    private long userId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Comment(long id, String text, long userId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
    }
}
