package blooossom.api.tag.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.tag.application.port.in.RegisterTagCommand;
import blooossom.api.tag.application.port.in.RegisterTagUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class RegisterTagController {

    private final RegisterTagUseCase registerTagUseCase;

    @PostMapping("/api/tag")
    public ResponseEntity<Void> registerTag(@RequestBody RegisterTagCommand command) {
        return registerTagUseCase.registerTag(command)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
