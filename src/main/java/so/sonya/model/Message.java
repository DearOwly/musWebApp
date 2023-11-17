package so.sonya.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Message {

    Long id;
    String text;
    UUID authorId;
    Instant dateOfWrite;
    Long postId;

}
