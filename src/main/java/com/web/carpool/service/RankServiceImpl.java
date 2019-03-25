package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.Rank;
import com.web.carpool.repository.RankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("rankService")
public class RankServiceImpl implements RankService {
    @Autowired
    @Qualifier("rankRepository")
    private RankRepository rankRepository;

    @Override
    public String test(String id) {
        return id;
    };

    @Override
    public Rank create(Rank rnk) {
        System.out.println("into rank create service: "+rnk.getDriverLicense());
        return rankRepository.save(rnk);
    };

    @Override
    public List<Rank> readAll() {
        System.out.println("into readAll");
        // try {
        //     return rankRepository.findAll();
        // } catch (Exception e) {
        //     System.out.println(e);
        //     return rankSample;
        // }
        return rankRepository.findAll();
    };

    @Override
    public Rank read(long id) {
        try {
            System.out.println("into service: ");
            return rankRepository.findById(id);
        } catch( Exception e) {
            System.out.print("catch error"+e);
            return new Rank();
        }
    };

    @Override
    public Rank update(Rank rnk) {
        return rankRepository.saveAndFlush(rnk);
    };

    @Override
    public void delete(Long id) {
        rankRepository.deleteById(id);
    };

}