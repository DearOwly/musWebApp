package so.sonya.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserEntity {

    UUID id;
    String name;
    String surname;
    String email;
    String password;
    Role role;
    public enum Role{
        ADMIN, USER, GUEST;
    }

}
