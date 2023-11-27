package so.sonya.service.impl;

import lombok.AllArgsConstructor;
import so.sonya.dao.UserDao;
import so.sonya.dto.RegistrationForm;
import so.sonya.dto.LogInForm;
import so.sonya.dto.UserEntityDto;
import so.sonya.model.UserEntity;
import so.sonya.service.AuthorizationService;
import so.sonya.service.PasswordEncoder;
import so.sonya.service.UserMapper;

import java.util.Optional;

@AllArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    @Override
    public UserEntityDto registration(RegistrationForm form) {
        if (form.getEmail() == null){
            throw new RuntimeException();
        }
        Optional<UserEntity> optionalUser = userDao.findByEmail(form.getEmail());
        if (optionalUser.isPresent()){
            throw new RuntimeException();
        }
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        UserEntity user = userMapper.toEntity(form);
        UserEntity savedUser = userDao.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserEntityDto signIn(LogInForm form) {
        return null;
    }
}
