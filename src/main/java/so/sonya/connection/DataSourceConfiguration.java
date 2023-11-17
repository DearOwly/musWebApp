package so.sonya.connection;

import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import so.sonya.connection.property.DbPropertyReader;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConfiguration {

    private volatile static DataSourceConfiguration instance;

    private final DataSource dataSource;

    private final DbPropertyReader reader = new DbPropertyReader();

    private DataSourceConfiguration() {
        reader.loadProperties();
        dataSource = configure(reader.getUsername(), reader.getPassword(), reader.getDbUrl(), reader.getDbDriver());
    }

    public static DataSourceConfiguration getInstance() {
        if (instance == null) {
            synchronized (DataSourceConfiguration.class) {
                instance = new DataSourceConfiguration();
            }
        }
        return instance;
    }


    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private DataSource configure(String username, String password, String url, String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}