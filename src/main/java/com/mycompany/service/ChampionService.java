package com.mycompany.service;

import com.mycompany.model.GameMatch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Repository
public class ChampionService {

    @PersistenceContext
    private EntityManager entityManager;

    public Collection<GameMatch> getAllMatchesForChampion(long championId) {
        String hql = "FROM GameMatch gm WHERE gm.winner.id = " + championId + " OR gm.loser.id = " + championId;
        return (Collection<GameMatch>) entityManager.createQuery(hql).getResultList();
    }

}
