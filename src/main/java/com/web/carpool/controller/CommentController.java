package com.web.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.carpool.model.Comment;
import com.web.carpool.service.CommentService; 

@RestController()
@RequestMapping(path="/comments")
public class CommentController {
    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;
    
    @GetMapping(path="/test")
    public @ResponseBody String testComment() {
        return commentService.test();
    }

    @PostMapping(path="")
    public @ResponseBody Comment createComment(@RequestBody Comment cmt) {

        return commentService.create(cmt);
    }
    
    @GetMapping(value="")
    public @ResponseBody Iterable<Comment> readAllComment() {
        return commentService.readAll();
        // return "Hello World";
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Comment readComment(@RequestParam long id) {
        return commentService.read(id);
    }
    

    @PutMapping(value="/{id}")
    public @ResponseBody Comment updateComment(@RequestParam long id, @RequestBody Comment cmt) {
        return commentService.update(id, cmt);
    }

    @DeleteMapping(value="/{id}")
    public @ResponseBody boolean deleteComment(@RequestParam long id) {
        return commentService.delete(id);
    }
    
}