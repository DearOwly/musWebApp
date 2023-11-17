package so.sonya.connection.property;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DbPropertyReader {

    String username;
    String password;
    String dbUrl;
    String dbDriver;

    public void loadProperties() {
        Properties prop = new Properties();
        InputStream stream = getClass().getResourceAsStream("/MyFile.properties");
        try {
            prop.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fillParams(prop);
    }

    private void fillParams(Properties properties) {
        setUsername(properties.getProperty("username"));
        setPassword(properties.getProperty("password"));
        setDbUrl(properties.getProperty("dbUrl"));
        setDbDriver(properties.getProperty("dbDriver"));
    }
}