package com.web.carpool.controller;

import java.util.List;

import com.web.carpool.model.Rank;
import com.web.carpool.service.RankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path="/rank")
public class RankController {
    @Autowired
    @Qualifier("rankService")
    private RankService rankService;

    ///////////////////test code: diff of 'RequestParam' & 'PathVariable'

    // @GetMapping("/test")
    // @ResponseBody
    // public String testRank(@RequestParam(name = "id", defaultValue = "000") String commentId) {
    //     // return rankService.test(commentId);
    //     Rank rankSample = new Rank();
    //     System.out.println("into read rank"+rankSample);
    //     return rankSample.toString();
    // }

    // @GetMapping("/test/{id}")
    // @ResponseBody
    // public String testRank(@PathVariable String id) {
    //     return rankService.test(id);
    // }

    ///////////////////

    @PostMapping()
    public @ResponseBody Rank createRank(@RequestBody Rank rnk) {
        System.out.println("into create rank"+rnk.getDriverLicense());
        return rankService.create(rnk);
    }

    @GetMapping()
    public @ResponseBody List<Rank> readAllRank() {
        System.out.println("into readALlRank");
        return rankService.readAll();
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Rank readRank(@PathVariable long id) {
        // Rank rankSample = new Rank();
        System.out.println("into read rank"+id);
        return rankService.read(id);
        // return rankSample;
    }
    

    @PutMapping()
    public @ResponseBody Rank updateRank(@RequestBody Rank rnk) {
        return rankService.update(rnk);
    }

    @DeleteMapping(value="/{commentId}")
    public void deleteRank(@PathVariable Long commentId) {
        rankService.delete(commentId);
    }
}