package blooossom.api.post.application.port.out;

import blooossom.api.post.domain.Post;

@FunctionalInterface
public interface RegisterPostPort {
    void registerPost(Post post);
}
