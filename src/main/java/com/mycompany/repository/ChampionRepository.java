package com.mycompany.repository;

import com.mycompany.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion findByName(String name);
}
