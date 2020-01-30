package main.java.by.vasiliuk.dao;

import main.java.by.vasiliuk.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findById(long id)throws DaoException ;
    boolean save(String username, String pass, int averageRating) throws DaoException ;
    long findIdByUsername(String username)throws DaoException ;
    String findPassByUserName(String username)throws DaoException ;
}