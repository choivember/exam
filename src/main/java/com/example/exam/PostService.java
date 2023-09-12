package com.example.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(int page, int size) {
        int offset = (page - 1) * size;
        return postRepository.findAll(offset, size);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepository.insert(post);
        return post;
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = postRepository.findById(id);
        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            postRepository.update(existingPost);
            return existingPost;
        }
        return null;
    }

    public boolean deletePost(Long id) {
        Post existingPost = postRepository.findById(id);
        if (existingPost != null) {
            postRepository.delete(id);
            return true;
        }
        return false;
    }
}
