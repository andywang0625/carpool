package com.web.carpool.repository;

import com.web.carpool.model.Rank;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("rankRepository")
public interface RankRepository extends CrudRepository<Rank, Integer> {

}