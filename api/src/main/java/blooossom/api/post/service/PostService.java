package blooossom.api.post.service;

import blooossom.api.post.dto.PostRequest;
import blooossom.api.post.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post getPost(String id);

    void deletePost(String id);

    boolean createPost(PostRequest.NewPost post);

    boolean updatePost(PostRequest.UpdatePost post);

}
