package main.java.by.vasiliuk.dao;

import main.java.by.vasiliuk.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findById(long id);
    boolean save(String username, String pass, int averageRating);
    long findIdByUsername(String username);
    String findPassByUserName(String username);
}
