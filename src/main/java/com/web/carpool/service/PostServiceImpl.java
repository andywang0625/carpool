package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Post;
import com.web.carpool.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;


	@Override
	public Post create(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post read(long id) {
        return postRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		postRepository.deleteById(id);
	}

	@Override
	public Post update(Post post) {
		return postRepository.saveAndFlush(post);
	}

	@Override
	public List<Post> readAll() {
		return postRepository.findAll();
	}

}