package blooossom.api.post.application.port.out;

import blooossom.api.post.domain.Post;

public interface UpdatePostPort {
    void updatePost(Post post);
}
