package by.vasiliuk.project.dao.impl;

import by.vasiliuk.project.dao.UserDao;
import by.vasiliuk.project.model.User;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.pool.ConnectionPool;
import by.vasiliuk.project.pool.ConnectionWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static by.vasiliuk.project.dao.DaoProvider.*;


public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findById(long id) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            String sql = SQL_FIND_USER_BY_ID;
             preparedStatement = connectionWrapper.prepareStatement(sql);
            preparedStatement.setLong(1, id);
             resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new User(resultSet.getLong(USER_ID),
                        resultSet.getString(USER_NAME),
                        resultSet.getInt(USER_RATING))) ;
            }
        } catch (SQLException e){
          throw new DaoException(e);
        } finally {
            try {
                //todo null check
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    @Override
    public String findPassByUserName(String username) throws DaoException{
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ResultSet resultSet = null;
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){

            PreparedStatement preparedStatement = connectionWrapper.prepareStatement(SQL_FIND_PASS_BY_USER_NAME);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString(USER_PASS);
        } catch (SQLException e){
           throw new DaoException(e);
        } finally {
            close(resultSet);
            // todo close statement

        }
    }

    @Override
    public boolean save(String username, String pass, int averageRating) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()) {
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_USER_SAVE;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            preparedStatement.setInt(3, averageRating);

            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long findIdByUsername(String username) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_BY_USER_NAME;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(USER_ID);
        }catch (SQLException e){
            throw new DaoException(e);
        }
    }

    public void delete(long id){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_USER_DELETE;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
