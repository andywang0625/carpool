package com.web.carpool.repository;

import com.web.carpool.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PostRepository")
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
}