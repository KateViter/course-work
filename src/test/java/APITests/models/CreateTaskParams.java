package APITests.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskParams implements Params{
    private String title;
    private int project_id;
    private int owner_id;
    private int creator_id;
}
