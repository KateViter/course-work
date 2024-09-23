package APITests.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoveProjectParams implements Params{
    private int project_id;
}
