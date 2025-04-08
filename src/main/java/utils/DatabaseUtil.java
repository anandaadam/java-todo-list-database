package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getDataSource() {
        if (hikariDataSource == null) {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
            hikariConfig.setUsername("root");
            hikariConfig.setPassword("");
            hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/java_oop_database");

            // pooling database config
            hikariConfig.setMaximumPoolSize(10);
            hikariConfig.setMinimumIdle(5);
            hikariConfig.setIdleTimeout(60_000);
            hikariConfig.setMaxLifetime(60 * 60 * 1000);

            hikariDataSource = new HikariDataSource(hikariConfig);
        }

        return hikariDataSource;
    }
}
