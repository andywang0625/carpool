package com.web.carpool.repository;

import com.web.carpool.model.Rank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rankRepository")
public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findById(long id);
}