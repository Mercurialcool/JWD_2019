package main.java.by.vasiliuk.pool;

public interface Pool {
    ConnectionWrapper getConnection();
    boolean releaseConnection(ConnectionWrapper connection);
    void close();
}
