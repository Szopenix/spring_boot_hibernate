package com.mycompany.repository;

import com.mycompany.model.GameMatch;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface GameMatchRepository extends CrudRepository<GameMatch, Long> {

    Collection<GameMatch> findByWinnerId(long id);
    Collection<GameMatch> findByLoserId(long id);
}
