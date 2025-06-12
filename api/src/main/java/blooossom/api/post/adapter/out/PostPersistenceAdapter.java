package blooossom.api.post.adapter.out;

import blooossom.api.global.annotations.PersistenceAdapter;
import blooossom.api.post.application.port.out.DeletePostPort;
import blooossom.api.post.application.port.out.RegisterPostPort;
import blooossom.api.post.application.port.out.UpdatePostPort;
import blooossom.api.post.domain.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@PersistenceAdapter
class PostPersistenceAdapter implements RegisterPostPort, UpdatePostPort, DeletePostPort {

    private final PostJpaRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void registerPost(Post post) {
        postRepository.save(postMapper.mapToJpaEntity(post));
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(postMapper.mapToJpaEntity(post));
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(postRepository.findById(post.getId().getValue()).orElseThrow());
    }
}
