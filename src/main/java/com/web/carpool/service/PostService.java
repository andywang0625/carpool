package com.web.carpool.service;
import java.util.List;
import com.web.carpool.model.Post;

public interface PostService {
    public Post create(Post post);
    public Post read(long post);
    public void delete(long id);
    public Post update(Post post);
    public List<Post> readAll();

}