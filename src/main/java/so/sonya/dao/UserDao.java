package so.sonya.dao;

import so.sonya.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends Dao<UserEntity, UUID>{
    Optional<UserEntity> findByEmail(String email);
}
