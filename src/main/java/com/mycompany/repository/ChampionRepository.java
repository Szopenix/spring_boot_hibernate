package com.mycompany.repository;

import com.mycompany.model.Champion;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ChampionRepository extends CrudRepository<Champion, Long> {

    Champion findByName(String name);
    Collection<Champion> findByUserId(long id);
    List<Champion> findAll();
}
