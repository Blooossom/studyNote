package blooossom.api.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class PostRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class NewPost {
        private String title;
        private String content;
        private String userId;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class UpdatePost {
        private String id;
        private String title;
        private String content;
        private String userId;
    }
}
