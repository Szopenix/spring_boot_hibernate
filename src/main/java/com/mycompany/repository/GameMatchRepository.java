package com.mycompany.repository;

import com.mycompany.model.GameMatch;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public interface GameMatchRepository extends CrudRepository<GameMatch, Long> {

    @Transactional
    void deleteByWinnerId(long id);

    @Transactional
    void deleteByLoserId(long id);

    Collection<GameMatch> findByWinnerId(long id);
    Collection<GameMatch> findByLoserId(long id);

}
