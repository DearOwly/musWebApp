package so.sonya.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import so.sonya.connection.DataSourceConfiguration;
import so.sonya.dao.UserDao;
import so.sonya.dto.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl<T> implements UserDao<T> {
    private final JdbcTemplate jdbcTemplate;

    //language=sql
    private final static String SQL_SELECT_ALL = "select * from users;";

    //language=sql
    private final static String SQL_INSERT = "insert into users (name, email, password) VALUES (?, ?, ?);";

    //language=sql
    private final static String SQL_SELECT_BY_ID = "select * from users where id = ?;";

    public UserDaoImpl(DataSourceConfiguration dataSource) {
        this.jdbcTemplate = new JdbcTemplate((DataSource) dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User item) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}