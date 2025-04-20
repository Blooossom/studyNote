package blooossom.api.post.repository;

import blooossom.api.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "postRepository")
public interface PostRepository extends JpaRepository<Post, String> {
}
