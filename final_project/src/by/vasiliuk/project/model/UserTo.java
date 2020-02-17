package by.vasiliuk.project.model;

import by.vasiliuk.project.model.Advert;

import java.util.ArrayList;
import java.util.List;

public class UserTo {
    private long id;
    private String username;
    private int rating;

    private List<Advert> adverts = new ArrayList<>();

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

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void addAdvert(Advert advert){
        adverts.add(advert);
    }

    public UserTo(long id, String username, int rating) {
        this.id = id;
        this.username = username;
        this.rating = rating;
    }
}
