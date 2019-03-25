package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Rank;

public interface RankService {
    public String test(String id);
    public Rank create(Rank rnk);
    public List<Rank> readAll();
    public Rank read(long id);
    public Rank update(Rank rnk);
    public void delete(Long id);
}