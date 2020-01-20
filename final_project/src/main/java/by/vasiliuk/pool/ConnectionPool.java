package main.java.by.vasiliuk.pool;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ConnectionPool implements Pool{

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private ArrayBlockingQueue<ConnectionWrapper> availableConnections;
    private ArrayBlockingQueue<ConnectionWrapper> usedConnections;

    private ConnectionPool(){
        InputStream input;
        Properties properties = new Properties();
        try {
            input = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
            String url = properties.getProperty("db.host");
            String user = properties.getProperty("db.login");
            String pass = properties.getProperty("db.password");

            availableConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty("connection-pool-size")));
            usedConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty("connection-pool-size")));

            Class.forName(properties.getProperty("db.driver-name")).getDeclaredConstructor().newInstance();
            for(int i = 0; i < Integer.parseInt(properties.
                    getProperty("connection-pool-size")); i++){
                availableConnections.add(new ConnectionWrapper(DriverManager.getConnection(url, user, pass)));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException | SQLException e) {
            //fatal
            throw new RuntimeException("Connection pool not created");
        } catch (IOException e){
            //fata
            throw new RuntimeException("Properties file not found");
        }
        //add shutdown hook
    }

    public static ConnectionPool getInstance(){
        return INSTANCE;
    }

    @Override
    public ConnectionWrapper getConnection(){
        ConnectionWrapper connection = null;
        InputStream input;
        Properties properties = new Properties();
        try {
            input = this.getClass().getClassLoader().
                    getResourceAsStream("config.properties");
            properties.load(input);
            connection = availableConnections.poll(Integer.
                    parseInt(properties.getProperty("wait-connection-timeout")), TimeUnit.SECONDS);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            //throw custom exception
        }
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(ConnectionWrapper connection){
        usedConnections.remove(connection);
        try {
            availableConnections.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //throw custom exception
        }
        return true;
    }

    @Override
    public void close(){
//        try {
//            //poll all connections before closing
//            for(ConnectionWrapper connection : availableConnections){
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
