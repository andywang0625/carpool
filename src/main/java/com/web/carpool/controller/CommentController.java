package com.web.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import com.web.carpool.model.Comment;
import com.web.carpool.repository.CommentRepository;;

@RestController()
@RequestMapping(path="comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    
    //Create
    @PostMapping(path="")
    public @ResponseBody Comment createComment(@RequestBody Comment cmt) {
        Comment cmtReply = new Comment();
        cmtReply.setPostId(cmt.getPostId());
        cmtReply.setUserId(cmt.getUserId());
        cmtReply.setComment(cmt.getComment());
        cmtReply.setRate(cmt.getRate());

        commentRepository.save(cmt);
        
        return cmtReply;
    }
    
    @GetMapping(value="")
    public @ResponseBody Iterable<Comment> readAllComment() {
        return commentRepository.findAll();
        // return "Hello World";
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Optional<Comment> readComment(@RequestParam Integer id) {
        return commentRepository.findById(id);
    }
    

    @PutMapping(value="/{id}")
    public @ResponseBody Optional<Comment> updateComment(@RequestParam Integer id, @RequestBody Comment cmt) {
        commentRepository.save(cmt);
        return commentRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    public @ResponseBody String deleteComment(@RequestParam Integer id) {
        // Optional<Comment> cmt = new Optional<Comment>();
        // cmt = commentRepository.findById(id);
        // commentRepository.delete(id);
        
        return "Deleted";
    }
    
}