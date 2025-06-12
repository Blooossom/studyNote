package blooossom.api.post.adapter.out;

import blooossom.api.global.annotations.PersistenceAdapter;
import blooossom.api.post.application.port.out.LoadPostPort;
import blooossom.api.post.domain.Post;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
class PostQueryAdapter implements LoadPostPort {

    private final PostJpaRepository postJpaRepository;

    private final PostMapper postMapper;

    @Override
    public Optional<Post> loadPostById(String id) {
        return Optional.ofNullable(postMapper.mapToDomainEntity(postJpaRepository.findById(id).orElseThrow(NoResultException::new)));
    }

    @Override
    public List<Post> loadPosts() {
        return postJpaRepository.findAll().stream().map(postMapper::mapToDomainEntity).toList();
    }
}
