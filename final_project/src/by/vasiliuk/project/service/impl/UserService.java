package by.vasiliuk.project.service.impl;

import by.vasiliuk.project.dao.UserDao;
import by.vasiliuk.project.model.User;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.dao.impl.UserDaoImpl;
import by.vasiliuk.project.service.ServiceException;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public static UserService getInstance(){
        return INSTANCE;
    }

    public String logInUser(String username) throws ServiceException {
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

    public Optional<String> findUsernameById(long id)throws ServiceException{
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
