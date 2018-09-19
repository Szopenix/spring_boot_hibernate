package com.mycompany.service;

import com.mycompany.model.GameMatch;
import com.mycompany.repository.GameMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Repository
public class ChampionService {

    @Autowired
    private GameMatchRepository gameMatchRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Collection<GameMatch> getAllMatches(long championId) {
        String hql = "FROM GameMatch gm WHERE gm.winner.id = " + championId + " OR gm.loser.id = " + championId;
        return (Collection<GameMatch>) entityManager.createQuery(hql).getResultList();
    }

    Collection<GameMatch> findByWinnerId(long id) {
        return gameMatchRepository.findByWinnerId(id);
    }

    Collection<GameMatch> findByLoserId(long id) {
        return gameMatchRepository.findByLoserId(id);
    }
}
