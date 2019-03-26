package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Comment;
import com.web.carpool.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;

    @Override
    public String test() {
        return "Test passed";
    }

    @Override
    public Comment create(Comment cmt) {
        return commentRepository.save(cmt);
    }

    @Override
    public List<Comment> readAll() {
        return commentRepository.findAll();
    }
    
    @Override
    public Comment read(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment update(long id, Comment cmt) {
        Comment newComment = new Comment();
        newComment = cmt;
        return commentRepository.saveAndFlush(newComment);
    }

    @Override
    public Boolean delete(long id) {
        return true;
        // try {
        //     commentRepository.deleteById(id);
        //     return true;
        // } catch(Exception exception){
        //     return false;
        // }
    }
}   