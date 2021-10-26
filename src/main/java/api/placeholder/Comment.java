package api.placeholder;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private int postId;
    private int id;
    private String email;
    private String body;
    private String name;
}
