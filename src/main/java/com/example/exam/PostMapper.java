package com.example.exam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll(@Param("offset") int offset, @Param("size") int size);

    Post findById(@Param("id") Long id);

    void insert(Post post);

    void update(Post post);

    void delete(@Param("id") Long id);
}

