package main.java.by.vasiliuk.dao.impl;

import main.java.by.vasiliuk.dao.UserDao;
import main.java.by.vasiliuk.model.User;
import main.java.by.vasiliuk.pool.ConnectionPool;
import main.java.by.vasiliuk.pool.ConnectionWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    private static final String USER_ID = "userId";
    private static final String USER_NAME = "userName";
    private static final String USER_RATING = "userAverageRating";
    private static final String USER_PASS = "userPass";

    private static final String SQL_FIND_BY_ID = "SELECT userId, userName, userAverageRating FROM users WHERE userId = ?";
    private static final String SQL_FIND_PASS_BY_USER_NAME = "SELECT userPass, userId FROM users WHERE userName = ?";
    private static final String SQL_FIND_BY_USER_NAME = "SELECT FROM users userId WHERE username = ?";
    private static final String SQL_SAVE = "INSERT INTO users (userName, userPass, userAverageRating) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM users WHERE userId = ?";

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_BY_ID;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new User(resultSet.getLong(USER_ID),
                        resultSet.getString(USER_NAME),
                        resultSet.getInt(USER_RATING))) ;
            }


        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public String findPassByUserName(String username){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_PASS_BY_USER_NAME;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString(USER_PASS);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(String username, String pass, int averageRating) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()) {
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_SAVE;
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
    public long findIdByUsername(String username){
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
            e.printStackTrace();
        }
        return 0;
    }

    public void delete(long id){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_DELETE;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
