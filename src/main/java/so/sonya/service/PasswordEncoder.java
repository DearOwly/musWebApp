package so.sonya.service;

public interface PasswordEncoder {

    boolean matches(String password, String hashPassword);
    String encode(String password);

}
