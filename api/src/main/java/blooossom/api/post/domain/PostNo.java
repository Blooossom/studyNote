package blooossom.api.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostNo {
    String value;
    public static PostNo of(String id) {
        return new PostNo(id);
    }
}
