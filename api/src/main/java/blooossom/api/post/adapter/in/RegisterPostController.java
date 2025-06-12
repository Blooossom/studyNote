package blooossom.api.post.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.post.application.port.in.RegisterPostCommand;
import blooossom.api.post.application.port.in.RegisterPostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class RegisterPostController {

    private final RegisterPostUseCase registerPostUseCase;

    @PostMapping(value = "/api/post", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> registerPost(@RequestBody RegisterPostCommand command) {
        registerPostUseCase.registerPost(command);
        return ResponseEntity.ok().build();
    }
}
