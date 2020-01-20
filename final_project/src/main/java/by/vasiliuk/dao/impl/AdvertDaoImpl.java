package main.java.by.vasiliuk.dao.impl;

import main.java.by.vasiliuk.dao.AdvertDao;
import main.java.by.vasiliuk.model.Advert;
import main.java.by.vasiliuk.pool.ConnectionPool;
import main.java.by.vasiliuk.pool.ConnectionWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdvertDaoImpl implements AdvertDao {

    private static final AdvertDaoImpl INSTANCE = new AdvertDaoImpl();

    public static AdvertDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Advert> getAll(){
        List<Advert> adverts = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = "SELECT advertId, advertTitle, advertText, userId FROM adverts";
            //sql constant in dao
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                adverts.add(new Advert(resultSet.getInt("advertId"),
                        resultSet.getString("advertTitle"),
                        resultSet.getString("advertText"),
                        resultSet.getLong("userId")));
                //column label name in model
            }

        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
        return adverts;
    }
    @Override
    public Optional<Advert> getById(long id){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = "SELECT advertId, advertTitle, advertText, userId FROM adverts WHERE advertId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new Advert(resultSet.getInt("advertId"),
                        resultSet.getString("advertTitle"),
                        resultSet.getString("advertText"),
                        resultSet.getLong("userId")));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(String advertTitle, String advertText, long userId){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = "INSERT INTO adverts (advertTitle, advertText, userId) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, advertTitle);
            preparedStatement.setString(2, advertText);
            preparedStatement.setLong(3, userId);

            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(long id){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = "DELETE FROM adverts WHERE advertId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Advert> getBySectionId(long id) {
        List<Advert> adverts = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try(ConnectionWrapper connectionWrapper = connectionPool.getConnection()){
            Connection connection = connectionWrapper.getConnection();
            String sql = "SELECT a.advertId, a.advertTitle, a.advertText," +
                    " a.userId FROM adverts a WHERE a.sectionId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                adverts.add(new Advert(resultSet.getLong("advertId"),
                        resultSet.getString("advertText"),
                        resultSet.getString("advertTitle"),
                        resultSet.getLong("userId")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return adverts;
    }
}
