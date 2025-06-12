package blooossom.api.post.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.post.application.port.in.UpdatePostCommand;
import blooossom.api.post.application.port.in.UpdatePostUseCase;
import blooossom.api.post.application.port.out.LoadPostPort;
import blooossom.api.post.application.port.out.UpdatePostPort;
import blooossom.api.post.domain.Post;
import blooossom.api.user.application.port.out.LoadUserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@UseCase
class UpdatePostService implements UpdatePostUseCase {

    private final UpdatePostPort updatePostPort;

    private final LoadPostPort loadPostPort;

    private final LoadUserPort loadUserPort;

    @Override
    public void updatePost(UpdatePostCommand command) {
        try {
            Post updated = Post.updateContentInfo(command, loadPostPort, loadUserPort);

            updatePostPort.updatePost(updated);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
