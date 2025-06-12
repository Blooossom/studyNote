package blooossom.api.post.adapter.out;

import blooossom.api.global.annotations.Mapper;
import blooossom.api.post.domain.Post;

@Mapper
class PostMapper {

    PostJpaEntity mapToJpaEntity(Post post) {
        return new PostJpaEntity(post.getId().getValue(), post.getTitle(), post.getContent(),
                post.getAuthor(), post.getCreatedAt(), post.getUpdatedAt());
    }

    Post mapToDomainEntity(PostJpaEntity post) {
        return Post.withTime(post.getId(), post.getTitle(), post.getContent(), post.getUserId(),
                post.getCreatedTime(), post.getModifiedTime());
    }
}
