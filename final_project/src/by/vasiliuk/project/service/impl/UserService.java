package main.java.by.vasiliuk.service;

import main.java.by.vasiliuk.dao.DaoException;
import main.java.by.vasiliuk.dao.UserDao;
import main.java.by.vasiliuk.dao.impl.UserDaoImpl;
import main.java.by.vasiliuk.model.User;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public static UserService getInstance(){
        return INSTANCE;
    }

    public String logInUser(String username) throws ServiceException{
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findPassByUserName(username);
        } catch (DaoException e) {
           throw new ServiceException(e);
        }
    }

    public long getUserId(String username)throws ServiceException{
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            return userDao.findIdByUsername(username);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void registerUser(String username, String pass, int averageRating)throws ServiceException{
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            userDao.save(username, pass, averageRating);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> findUser(long id)throws ServiceException{
        UserDao userDao = new UserDaoImpl();
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<String> getUsernameById(long id)throws ServiceException{
        UserDao userDao = UserDaoImpl.getInstance();
        Optional<User> user = null;
        try {
            user = userDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user.map(User::getUsername);
    }
}
