package com.web.carpool.service;

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
    public Comment create(Comment cmt) {
        
    }

    @Override
    public Comment readAll() {
        
    }

    @Override
    public Comment read(long id) {
        
    }

    @Override
    public Comment update(long id, Comment cmt) {
        
    }

    @Override
    public Boolean delete(long id) {
        
    }
}