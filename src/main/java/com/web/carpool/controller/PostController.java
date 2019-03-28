package com.web.carpool.controller;

import com.web.carpool.model.Post;
import com.web.carpool.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping(path = "/post")
public class PostController {
    // @PostMapping(value="/createPost")
    @Autowired
    @Qualifier("postService")
    public PostService postService;

    @PostMapping(value="/path")
    public @ResponseBody Post getPostById(@PathVariable(value = "id") int postid) {
        //TODO: process POST request
        return postService.findPostById(postid);
    }
    

    


}