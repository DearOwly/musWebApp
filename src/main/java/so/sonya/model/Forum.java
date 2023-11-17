package so.sonya.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Forum {

    Long id;
    UUID createrId;
    String title;
    Set<UserEntity> users;

}
