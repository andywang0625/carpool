package com.web.carpool.service;

import com.web.carpool.model.Post;
import com.web.carpool.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl implements PostService{

    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    @Override
	public Post findPostById(int id) {
		return postRepository.findById(id);
	}


}
