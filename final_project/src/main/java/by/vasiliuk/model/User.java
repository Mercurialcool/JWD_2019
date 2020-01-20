package main.java.by.vasiliuk.model;

public class User {
    private long id;
    private String username;
    private int rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User(long id, String username, int rating) {
        this.id = id;
        this.username = username;
        this.rating = rating;
    }
}
