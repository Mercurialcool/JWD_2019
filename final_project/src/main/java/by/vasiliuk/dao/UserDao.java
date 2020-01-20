package main.java.by.vasiliuk.dao;

import main.java.by.vasiliuk.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> getById(long id);
    boolean save(String username, String pass, int averageRating);
    long getIdByUsername(String username);
    String getPassByUserName(String username);
}
