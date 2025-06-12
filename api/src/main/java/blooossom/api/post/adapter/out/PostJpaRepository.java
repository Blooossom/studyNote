package blooossom.api.post.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "postRepository")
interface PostJpaRepository extends JpaRepository<PostJpaEntity, String> {
}
