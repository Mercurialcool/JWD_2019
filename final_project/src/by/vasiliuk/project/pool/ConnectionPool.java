package by.vasiliuk.project.pool;

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

    private static final String DB_HOST = "db.host";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD = "db.password";
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String CONNECTION_POOL_SIZE = "connection-pool-size";
    private static final String DB_DRIVER = "db.driver-name";
    private static final String CONNECTION_TIMEOUT = "wait-connection-timeout";

    private ArrayBlockingQueue<ConnectionWrapper> availableConnections;
    private ArrayBlockingQueue<ConnectionWrapper> usedConnections;

    private ConnectionPool(){
        InputStream input;
               Properties properties = new Properties();
            try {
                input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
                properties.load(input);
                String url = properties.getProperty(DB_HOST);
                String user = properties.getProperty(DB_LOGIN);
                String pass = properties.getProperty(DB_PASSWORD);

            availableConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty(CONNECTION_POOL_SIZE)));
            usedConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty(CONNECTION_POOL_SIZE)));

            Class.forName(properties.getProperty(DB_DRIVER)).getDeclaredConstructor().newInstance();
            for(int i = 0; i < Integer.parseInt(properties.
                    getProperty(CONNECTION_POOL_SIZE)); i++){
                availableConnections.add(new ConnectionWrapper(DriverManager.getConnection(url, user, pass)));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException | SQLException e) {
            //fatal
            throw new RuntimeException("Connection pool not created", e);
        } catch (IOException e){
            //fata
            throw new RuntimeException("Properties file not found", e);
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
                    getResourceAsStream(CONFIG_PROPERTIES);
            properties.load(input);
            connection = availableConnections.poll(Integer.
                    parseInt(properties.getProperty(CONNECTION_TIMEOUT)), TimeUnit.SECONDS);
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
    public void close() {

    }
    }

