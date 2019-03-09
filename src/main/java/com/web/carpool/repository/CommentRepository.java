package com.web.carpool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.carpool.model.Comment;

@Repository("commentRepository")
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
}