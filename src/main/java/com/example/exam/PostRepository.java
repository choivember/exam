package com.example.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    private final PostMapper postMapper;

    @Autowired
    public PostRepository(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<Post> findAll(int offset, int size) {
        return postMapper.findAll(offset, size);
    }

    public Post findById(Long id) {
        return postMapper.findById(id);
    }

    public void insert(Post post) {
        postMapper.insert(post);
    }

    public void update(Post post) {
        postMapper.update(post);
    }

    public void delete(Long id) {
        postMapper.delete(id);
    }
}

