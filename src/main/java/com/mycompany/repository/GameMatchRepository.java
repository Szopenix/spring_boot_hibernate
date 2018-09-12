package com.mycompany.repository;

import com.mycompany.model.GameMatch;
import com.mycompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMatchRepository extends JpaRepository<GameMatch, Long> {
}
