package utils;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    @Test
    void testConnection() throws SQLException {
        HikariDataSource hikariDataSource = DatabaseUtil.getDataSource();
        Connection connection = hikariDataSource.getConnection();

        connection.close();
        hikariDataSource.close();
    }
}
