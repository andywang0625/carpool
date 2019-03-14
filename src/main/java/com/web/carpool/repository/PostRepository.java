package com.web.carpool.repository;

import com.web.carpool.model.PostModel;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, Integer> {
    
}