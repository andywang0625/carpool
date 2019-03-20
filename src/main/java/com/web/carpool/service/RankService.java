package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Rank;

public interface RankService {
    public Rank create(Rank rnk);
    public List<Rank> readAll();
    public Rank read(long id);
    public Rank update(long id, Rank rnk);
    public boolean delete(long id);
}