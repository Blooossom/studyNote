package blooossom.api.post.application.port.in;

import lombok.Getter;

@Getter
public class UpdatePostCommand {
    String id;
    String title;
    String content;
    String userId;
}
