package com.web.carpool.controller;
import java.util.List;
import com.web.carpool.model.Post;
import com.web.carpool.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping(path = "/post")
public class PostController {
    // @PostMapping(value="/createPost")
    @Autowired
    @Qualifier("postService")
    public PostService postService;

    @PostMapping(value="/path")
    public @ResponseBody Post createPost(@RequestBody Post post) {
        //TODO: process POST request
        // return postService.findById(postid);
        return postService.create(post);
    }

    @GetMapping()
    public @ResponseBody List<Post> readAllPost(){
        return postService.readAll();
    }
    
    @GetMapping(value="/{id}") //??what why need /{id} here?
    public @ResponseBody Post readPost(@PathVariable long id){
        return postService.read(id);
    }
    
    @PutMapping()
    public @ResponseBody Post updatePost(@RequestBody Post post){
        return postService.update(post);
    }

    @DeleteMapping(value="/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }


}