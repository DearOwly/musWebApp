package so.sonya.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import so.sonya.model.UserEntity;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserEntityDto {

    UUID id;
    String name;
    String surname;
    String email;
    String password;
    UserEntity.Role role;

}
