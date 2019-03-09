package com.web.carpool.controller;

import java.util.Optional;

import com.web.carpool.model.Rank;
import com.web.carpool.repository.RankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping(path="rank")
public class RankController {
    @Autowired
    private RankRepository rankRepository;

    @PostMapping(path="")
    public @ResponseBody Optional<Rank> createRank(@RequestBody Rank rnk) {
        rankRepository.save(rnk);
        return rankRepository.findById(rnk.getUserId());
    }

    @GetMapping(value="")
    public @ResponseBody Iterable<Rank> readAllRank() {
        return rankRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Optional<Rank> readRank(@RequestParam Integer id) {
        return rankRepository.findById(id);
    }
    

    @PutMapping(value="/{id}")
    public @ResponseBody Optional<Rank> updateRank(@RequestParam Integer id, @RequestBody Rank cmt) {
        rankRepository.save(cmt);
        return rankRepository.findById(id);
    }

    @DeleteMapping(value="/{id}")
    public @ResponseBody String deleteRank(@RequestParam Integer id) {
        // Optional<Rank> cmt = new Optional<Rank>();
        // cmt = rankRepository.findById(id);
        // rankRepository.delete(id);
        
        return "Deleted";
    }
}