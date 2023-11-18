package so.sonya.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import so.sonya.dao.UserDao;
import so.sonya.model.UserEntity;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;


    private final RowMapper<UserEntity> rowMapper = (row, rowNumber) -> UserEntity.builder()
            .id((UUID) row.getObject("id"))
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public UserEntity save(UserEntity model) {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public boolean update(UserEntity model, UUID id) {
        return false;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.empty();
    }

    private class SqlQueryCompanion {
        //language=sql
        private final static String SAVE = "insert into user(name, surname, email, password) values (?, ?, ?, ?)";
        //language=sql
        private final static String FIND_ALL = "select * from user";
        //language=sql
        private final static String FIND_BY_ID = "";
        //language=sql
        private final static String FIND_BY_EMAIL = "";
    }
}
