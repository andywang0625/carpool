package com.web.carpool.controller;

import com.web.carpool.model.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CommentController {
    
    //Create
    @PostMapping(path="create-comment")
    public Comment createComment(@RequestBody Comment commentContext) {
        Comment comment = new Comment();
        comment.setPostId(commentContext.getPostId());
        comment.setUserId(commentContext.getUserId());
        comment.setComment(commentContext.getComment());
        comment.setRate(commentContext.getRate());
        
        return comment;
    }
    
    // @GetMapping(value="/{postId}")
    // public SomeData getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }

    // @PostMapping(value="update")
    // public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }

    // @PostMapping(value="delete")
    // public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }
    
}