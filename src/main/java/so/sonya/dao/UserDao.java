package so.sonya.dao;

import so.sonya.dao.generic.CrudRepository;
import so.sonya.dto.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserDao<T> extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
