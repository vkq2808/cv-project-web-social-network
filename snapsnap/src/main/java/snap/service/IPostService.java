package snap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import snap.entities.Post;

@Service
public interface IPostService {

	List<Post> getAllPosts();

	Post getPostById(Long postId);

	Post savePost(Post post);

	void deletePost(Long postId);
}
