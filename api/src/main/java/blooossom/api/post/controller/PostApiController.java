package blooossom.api.post.controller;

import blooossom.api.post.dto.PostRequest;
import blooossom.api.post.entity.Post;
import blooossom.api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/post")
@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping
    public ResponseEntity<Post> getPost(@RequestParam String id) {
        Post post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }


    @PutMapping()
    public ResponseEntity<Void> updatePost(PostRequest.UpdatePost updatePost) {
        return postService.updatePost(updatePost)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
    @PostMapping()
    public ResponseEntity<Void> createPost(PostRequest.NewPost newPost) {
        return postService.createPost(newPost)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost (@PathVariable String id) {
        try {
            postService.deletePost(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
