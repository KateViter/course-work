package APITests.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseRequest {
    private String jsonrpc;
    private String method;
    private int id;
    private Params params;
}
