package blooossom.api.post.service;

import blooossom.api.global.utils.IdGenerator;
import blooossom.api.post.dto.PostRequest;
import blooossom.api.post.entity.Post;
import blooossom.api.post.repository.PostRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service(value = "postService")
public class PostApiService implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public Post getPost(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    @Override
    public boolean createPost(PostRequest.NewPost request) {
        try {
            Post newPost = new Post(
                    IdGenerator.getUUID64(),
                    request.getTitle(),
                    request.getContent(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            postRepository.save(newPost);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePost(PostRequest.UpdatePost request) {
        try {
            Post post = postRepository.findById(request.getId()).orElseThrow(NoResultException::new);

            post.setTitle(request.getTitle());
            post.setContent(request.getContent());
            post.setModifiedTime(LocalDateTime.now());

            postRepository.save(post);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
