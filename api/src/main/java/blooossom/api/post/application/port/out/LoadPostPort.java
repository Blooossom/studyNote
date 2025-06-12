package blooossom.api.post.application.port.out;

import blooossom.api.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface LoadPostPort {
    Optional<Post> loadPostById(String id);

    List<Post> loadPosts();
}
