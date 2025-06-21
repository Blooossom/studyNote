package blooossom.api.post.domain;

import blooossom.api.post.application.port.in.UpdatePostCommand;
import blooossom.api.post.application.port.out.LoadPostPort;
import blooossom.api.tag.domain.Tag;
import blooossom.api.user.application.port.out.LoadUserPort;
import blooossom.api.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Builder(access = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {
    private PostNo id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Tag> tags;

    public static Post of(String id, String title, String content, String author) {
        return Post.builder()
                .id(PostNo.of(id))
                .title(title)
                .content(content)
                .author(author)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Post withTime(String id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return Post.builder()
                .id(PostNo.of(id))
                .title(title)
                .content(content)
                .author(author)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static Post updateContentInfo(UpdatePostCommand command, LoadPostPort loadPostPort, LoadUserPort loadUserPort) {
        Post post = loadPostPort.loadPostById(command.getId()).orElseThrow(() -> new NoSuchElementException("Post not found"));
        User user = loadUserPort.loadUserById(command.getUserId()).orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!post.getId().getValue().equals(user.getId())) throw new IllegalArgumentException();

        return Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .updatedAt(LocalDateTime.now())
                .build();

    }
}
