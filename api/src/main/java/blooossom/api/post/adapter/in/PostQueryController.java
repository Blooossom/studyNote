package blooossom.api.post.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.post.application.port.in.GetPostQuery;
import blooossom.api.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class PostQueryController {

    private final GetPostQuery getPostQuery;

    @GetMapping("/api/post")
    public ResponseEntity<List<Post>> getAllPost() {
        return ResponseEntity.ok(getPostQuery.getPosts());
    }

    @GetMapping("/api/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") String id) {
        return ResponseEntity.ok(getPostQuery.getPostById(id));
    }
}
