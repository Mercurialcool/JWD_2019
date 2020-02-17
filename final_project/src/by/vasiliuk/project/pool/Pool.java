package by.vasiliuk.project.pool;

public interface Pool {
    ConnectionWrapper getConnection();
    boolean releaseConnection(ConnectionWrapper connection);
    void closePool();
}
