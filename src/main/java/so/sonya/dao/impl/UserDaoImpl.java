package so.sonya.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import so.sonya.connection.DataSourceConfiguration;
import so.sonya.dao.UserDao;
import so.sonya.model.UserEntity;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
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

    public UserDaoImpl(DataSourceConfiguration dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public UserEntity save(UserEntity model) {
        if (model.getId() == null){
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SqlQueryCompanion.SAVE, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, model.getName());
                statement.setString(2, model.getSurname());
                statement.setString(3, model.getEmail());
                statement.setString(4, model.getPassword());
                return statement;
            }, keyHolder);
            UUID uuid = (UUID) keyHolder.getKeys().get("id");
            model.setId(uuid);
            return model;
        } else {
            //TODO: update realization
            return null;
        }
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(SqlQueryCompanion.FIND_BY_ID, rowMapper, id));
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query(SqlQueryCompanion.FIND_ALL, rowMapper);
    }

    @Override
    public boolean delete(UUID id) {
        return jdbcTemplate.update(SqlQueryCompanion.DELETE_BY_ID, id) > 0;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SqlQueryCompanion.FIND_BY_EMAIL, rowMapper, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private class SqlQueryCompanion {
        //language=sql
        private final static String SAVE = "insert into user(name, surname, email, password) values (?, ?, ?, ?)";
        //language=sql
        private final static String FIND_ALL = "select * from user";
        //language=sql
        private final static String FIND_BY_ID = "select * from user where id = ?";
        //language=sql
        private final static String FIND_BY_EMAIL = "select * from user where email = ?";
        //language=sql
        private final static String DELETE_BY_ID = "delete from user where id = ?";

    }
}
