package blooossom.api.post.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.global.utils.IdGenerator;
import blooossom.api.post.application.port.in.RegisterPostCommand;
import blooossom.api.post.application.port.in.RegisterPostUseCase;
import blooossom.api.post.application.port.out.RegisterPostPort;
import blooossom.api.post.domain.Post;
import blooossom.api.user.application.port.out.LoadUserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@UseCase
class RegisterPostService implements RegisterPostUseCase {

    private final RegisterPostPort registerPostPort;

    private final LoadUserPort loadUserPort;

    @Override
    public void registerPost(RegisterPostCommand command) {
        try {
            validateCommand(command);

            registerPostPort.registerPost(Post.of(IdGenerator.getUUID32(),
                    command.title(), command.content(), command.userId()));
        } catch (Exception e) {
            errorLogger(e);
        }
    }

    void validateCommand(RegisterPostCommand command) {
        loadUserPort.loadUserById(command.userId())
                .orElseThrow(() -> new RuntimeException("User with id " + command.userId() + " not found"));
    }

    void errorLogger(Exception e) {
        log.error(e.getMessage(), e);
    }
}
