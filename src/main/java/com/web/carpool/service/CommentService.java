package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Comment;

public interface CommentService {
    public String test();
    public Comment create(Comment cmt);
    public List<Comment> readAll();
    public Comment read(long id);
    public Comment update(long id, Comment cmt);
    public Boolean delete(long id);
}