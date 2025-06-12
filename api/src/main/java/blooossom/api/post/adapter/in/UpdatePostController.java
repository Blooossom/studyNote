package blooossom.api.post.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.post.application.port.in.UpdatePostCommand;
import blooossom.api.post.application.port.in.UpdatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class UpdatePostController {

    private final UpdatePostUseCase updatePostUseCase;

    @PutMapping("/api/post")
    public ResponseEntity<Void> updatePost(@RequestBody UpdatePostCommand command) {
        updatePostUseCase.updatePost(command);
        return ResponseEntity.noContent().build();
    }

}
