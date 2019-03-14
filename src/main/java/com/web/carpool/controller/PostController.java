package com.web.carpool.controller;

import com.web.carpool.model.Post;
import com.web.carpool.repository.PostModel;
import com.web.carpool.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "post")
public class PostController extends Post {
    // @PostMapping(value="/createPost")
    @Autowired
    public PostRepository postRepository;
    private CrudRepository<PostModel, Integer> crudRepository;

 //   @GetMapping(path="/1")
    // public @ResponseBody String addnewPost(@RequestParam int post_id, @RequestParam int user_id, @RequestParam String destination, @RequestParam String car_plate ) {
    //     Post pm = new Post();
    //     pm.setpostId(post_id);
    //     pm.setuserId(user_id);
    //     pm.setCarPlate(car_plate);
    //     pm.setDestination(destination);
    //     return "save";
    // }
 //   @GetMapping(path = "2")

    @PostMapping(value="path")
    public @ResponseBody String addNewUser(@RequestBody Post post) {
        //TODO: process POST request
        postRepository.save(post);
        return "save";
    }
    

    


}