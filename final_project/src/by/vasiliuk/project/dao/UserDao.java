package by.vasiliuk.project.dao;

import by.vasiliuk.project.model.User;

import java.util.Optional;

public interface UserDao extends BaseDao {
    Optional<User> findById(long id)throws DaoException ;  // FIXME: 01.02.2020 
    boolean save(String username, String pass, int averageRating) throws DaoException ;
    long findIdByUsername(String username)throws DaoException ;
    String findPassByUserName(String username)throws DaoException ;
}
