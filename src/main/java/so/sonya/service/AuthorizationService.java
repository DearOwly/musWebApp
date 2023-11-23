package so.sonya.service;

import so.sonya.dto.RegistrationForm;
import so.sonya.dto.SignInForm;
import so.sonya.dto.UserEntityDto;

public interface AuthorizationService {

    UserEntityDto registration(RegistrationForm form);
    UserEntityDto signIn(SignInForm form);

}
