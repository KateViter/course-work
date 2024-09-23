package APITests.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoveUserParams implements Params {
    private int user_id;
}
