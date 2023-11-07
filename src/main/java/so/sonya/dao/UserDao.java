package so.sonya.dao;

import so.sonya.dao.generic.CrudRepository;
import so.sonya.dto.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao<T> extends CrudRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
