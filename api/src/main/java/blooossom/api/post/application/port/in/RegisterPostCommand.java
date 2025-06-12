package blooossom.api.post.application.port.in;

public record RegisterPostCommand(String title, String content, String userId) {
}
