package by.vasiliuk.project.service;

public interface UserService {
    String logInUser(String username) throws ServiceException;
    long getUserId(String username)throws ServiceException;
}
