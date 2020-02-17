package by.vasiliuk.project.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDao {
    Logger logger = LogManager.getLogger();
    default void close(ResultSet set){
        if(set != null){
            try {
                set.close();
            } catch (SQLException e) {
                logger.error("resulset not closed", e);
            }
        }
    }
}
