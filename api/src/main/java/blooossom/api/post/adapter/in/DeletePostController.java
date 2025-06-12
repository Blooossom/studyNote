package blooossom.api.post.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.post.application.port.in.DeletePostCommand;
import blooossom.api.post.application.port.in.DeletePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class DeletePostController {

    private final DeletePostUseCase deletePostUseCase;

    @DeleteMapping("/api/post")
    public ResponseEntity<Void> deletePost(DeletePostCommand command) {
        deletePostUseCase.deletePost(command);
        return ResponseEntity.noContent().build();
    }
}
