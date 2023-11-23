package so.sonya.service;

import so.sonya.dto.RegistrationForm;
import so.sonya.dto.UserEntityDto;
import so.sonya.model.UserEntity;

public interface UserMapper {

    UserEntityDto toDto(UserEntity user);
    UserEntity toEntity(UserEntityDto dto);
    UserEntity toEntity(RegistrationForm dto);

}
