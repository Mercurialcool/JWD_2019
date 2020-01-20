package main.java.by.vasiliuk.service;

import main.java.by.vasiliuk.dao.UserDao;
import main.java.by.vasiliuk.dao.impl.UserDaoImpl;
import main.java.by.vasiliuk.model.User;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public static UserService getInstance(){
        return INSTANCE;
    }

    public String logInUser(String username){
        UserDao userDao = UserDaoImpl.getInstance();
        return userDao.getPassByUserName(username);
    }

    public long getUserId(String username){
        UserDao userDao = UserDaoImpl.getInstance();
        return userDao.getIdByUsername(username);
    }

    public void registerUser(String username, String pass, int averageRating){
        UserDao userDao = UserDaoImpl.getInstance();
        userDao.save(username, pass, averageRating);
    }

    public Optional<User> getUser(long id){
        UserDao userDao = new UserDaoImpl();
        return userDao.getById(id);
    }

    public Optional<String> getUsernameById(long id){
        UserDao userDao = UserDaoImpl.getInstance();
        Optional<User> user = userDao.getById(id);
        return user.map(User::getUsername);
    }
}
