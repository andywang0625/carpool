package com.web.carpool.controller;

import java.util.Optional;

import com.web.carpool.model.Rank;
import com.web.carpool.repository.RankRepository;
import com.web.carpool.service.RankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping(path="/rank")
public class RankController {
    @Autowired
    @Qualifier("rankService")
    private RankService rankService;

    @PostMapping(path="")
    public @ResponseBody Rank createRank(@RequestBody Rank rnk) {
        return rankService.create(rnk);
    }

    @GetMapping(value="")
    public @ResponseBody Iterable<Rank> readAllRank() {
        return rankService.readAll();
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Rank readRank(@RequestParam long id) {
        return rankService.read(id);
    }
    

    @PutMapping(value="/{id}")
    public @ResponseBody Rank updateRank(@RequestParam long id, @RequestBody Rank rnk) {
        return rankService.update(id, rnk);
    }

    @DeleteMapping(value="/{id}")
    public @ResponseBody boolean deleteRank(@RequestParam long id) {
        return rankService.delete(id);
    }
}