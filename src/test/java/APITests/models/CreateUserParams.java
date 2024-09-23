package APITests.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserParams implements Params {
    private String username;
    private int password;
    private String role;
}
