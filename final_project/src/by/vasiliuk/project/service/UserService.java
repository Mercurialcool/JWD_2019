package by.vasiliuk.project.service;

import by.vasiliuk.project.model.User;

import java.util.Optional;

public interface UserService {
    String logInUser(String username) throws ServiceException;
    long getUserId(String username) throws ServiceException;
    public void registerUser(String username, String pass, String averageRating) throws ServiceException;
    public Optional<User> findUser(long id) throws ServiceException;
    public Optional<String> findUsernameById(long id) throws ServiceException;
}
