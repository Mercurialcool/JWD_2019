package by.vasiliuk.project.dao.impl;

import by.vasiliuk.project.dao.AdvertDao;
import by.vasiliuk.project.dao.DaoException;
import by.vasiliuk.project.model.Advert;
import by.vasiliuk.project.pool.ConnectionPool;
import by.vasiliuk.project.pool.ConnectionWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.vasiliuk.project.dao.DaoProvider.*;

public class AdvertDaoImpl implements AdvertDao {

    private static final AdvertDaoImpl INSTANCE = new AdvertDaoImpl();

    public static AdvertDaoImpl getInstance() throws DaoException {
        return INSTANCE;
    }

    @Override
    public List<Advert> findAll() throws DaoException{
        List<Advert> adverts = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_ALL;
            //sql constant in dao
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                adverts.add(new Advert(resultSet.getInt(ADVERT_ID),
                        resultSet.getString(ADVERT_TITLE),
                        resultSet.getString(ADVERT_TEXT),
                        resultSet.getLong(USER_ID)));
                //column label name in model
            }

        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
        return adverts;
    }
    @Override
    public Optional<Advert> findById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_ADVERT_BY_ID;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new Advert(resultSet.getInt(ADVERT_ID),
                        resultSet.getString(ADVERT_TITLE),
                        resultSet.getString(ADVERT_TEXT),
                        resultSet.getLong(USER_ID)));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(String advertTitle, String advertText, long userId) throws DaoException{
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_ADVERT_SAVE;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, advertTitle);
            preparedStatement.setString(2, advertText);
            preparedStatement.setLong(3, userId);

            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(long id) throws DaoException{
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_ADVERT_DELETE;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Advert> findBySectionId(long id) throws DaoException {
        List<Advert> adverts = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = SQL_FIND_BY_SECTION_ID;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                adverts.add(new Advert(resultSet.getLong(ADVERT_ID),
                        resultSet.getString(ADVERT_TEXT),
                        resultSet.getString(ADVERT_TITLE),
                        resultSet.getLong(USER_ID)));
            }

        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            ///
        }
        return adverts;
    }
}
