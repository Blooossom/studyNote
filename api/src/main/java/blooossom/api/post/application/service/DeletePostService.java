package blooossom.api.post.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.post.application.port.in.DeletePostCommand;
import blooossom.api.post.application.port.in.DeletePostUseCase;
import blooossom.api.post.application.port.out.DeletePostPort;
import blooossom.api.post.application.port.out.LoadPostPort;
import blooossom.api.post.domain.Post;
import blooossom.api.user.application.port.out.LoadUserPort;
import blooossom.api.user.domain.User;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.naming.AuthenticationException;

@Slf4j
@RequiredArgsConstructor
@UseCase
class DeletePostService implements DeletePostUseCase {

    private final LoadPostPort loadPostPort;

    private final LoadUserPort loadUserPort;

    private final DeletePostPort deletePostPort;

    @Override
    public void deletePost(DeletePostCommand command) {
        try {
            User user = loadUserPort.loadUserById(command.userId()).orElseThrow(() -> new NoResultException("User not found"));
            Post post = loadPostPort.loadPostById(command.postId()).orElseThrow(() -> new NoResultException("Post not found"));

            if (!user.getId().equals(post.getAuthor())) throw new AuthenticationException("You are not authorized to delete this post");

            deletePostPort.deletePost(post);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
