package com.mycompany.repository;

import com.mycompany.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion findByName(String name);
    Collection<Champion> findByUserId(long id);
}
