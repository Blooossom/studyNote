package blooossom.api.post.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.post.application.port.in.GetPostQuery;
import blooossom.api.post.application.port.out.LoadPostPort;
import blooossom.api.post.domain.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@UseCase
class GetPostByIdService implements GetPostQuery {

    private final LoadPostPort loadPostPort;

    @Override
    public Post getPostById(String id) {
        return loadPostPort.loadPostById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Post> getPosts() {
        return loadPostPort.loadPosts();
    }
}
