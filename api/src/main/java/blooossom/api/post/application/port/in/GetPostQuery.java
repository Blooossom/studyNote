package blooossom.api.post.application.port.in;

import blooossom.api.post.domain.Post;

import java.util.List;

public interface GetPostQuery {

    Post getPostById(String id);

    List<Post> getPosts();
}
