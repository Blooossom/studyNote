package blooossom.api.post.application.port.in;

import blooossom.api.tag.domain.Tag;

import java.util.List;

public record RegisterPostCommand(String title, String content, String userId, List<Tag> tags) {
}
