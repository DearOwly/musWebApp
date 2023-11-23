package so.sonya.service.impl;

import so.sonya.dto.RegistrationForm;
import so.sonya.dto.UserEntityDto;
import so.sonya.model.UserEntity;
import so.sonya.service.UserMapper;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntityDto toDto(UserEntity user) {
        return UserEntityDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserEntity toEntity(UserEntityDto dto) {
        return UserEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public UserEntity toEntity(RegistrationForm dto) {
        return UserEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
