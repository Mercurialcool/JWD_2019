package by.vasiliuk.project.pool;


import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool implements Pool{

    private static ConnectionPool pool;

    private static final String DB_HOST = "db.host";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD = "db.password";

    private static final String CONNECTION_POOL_SIZE = "connection-pool-size";
    private static final String DB_DRIVER = "db.driver-name";
    private static final String CONNECTION_TIMEOUT = "wait-connection-timeout";
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean created = new AtomicBoolean(false);
    private ArrayBlockingQueue<ConnectionWrapper> availableConnections;
    private ArrayBlockingQueue<ConnectionWrapper> usedConnections;
// double check singleton --- lock, atomic  todo
    private ConnectionPool(){
        Properties properties = PoolConfigurator.getConfigurator().getProperties();
                String url = properties.getProperty(DB_HOST);
                String user = properties.getProperty(DB_LOGIN);
                String pass = properties.getProperty(DB_PASSWORD);

            availableConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty(CONNECTION_POOL_SIZE)));
            usedConnections = new ArrayBlockingQueue<>(Integer.
                    parseInt(properties.getProperty(CONNECTION_POOL_SIZE)));
            try{
            int poolSize = Integer.parseInt(properties.getProperty(CONNECTION_POOL_SIZE));
            Class.forName(properties.getProperty(DB_DRIVER)).getDeclaredConstructor().newInstance();
            for(int i = 0; i < poolSize; i++){
                availableConnections.add(new ConnectionWrapper(DriverManager.getConnection(url, user, pass)));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException | SQLException e) {
            //fatal
            throw new RuntimeException("Connection pool not created", e);
        }
        //add shutdown hook
    }

    public static ConnectionPool getInstance(){
        if (!created.get()) {//todo make getAbdSet sepatarely
            try {
                lock.lock();
                if (pool == null) {
                    pool = new ConnectionPool();
                    created.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return pool;
    }

    @Override
    public ConnectionWrapper getConnection(){
        ConnectionWrapper connection = null;
        try{
            connection = availableConnections.take();
        } catch (InterruptedException e) {
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
    public void closePool() {
// close availableConnections
       // deregister drivers
    }
    }

