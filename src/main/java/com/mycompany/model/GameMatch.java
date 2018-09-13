package com.mycompany.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GameMatch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private LocalDateTime matchDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Champion winner;

    @ManyToOne(fetch = FetchType.LAZY)
    private Champion loser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public Champion getWinner() {
        return winner;
    }

    public void setWinner(Champion winner) {
        this.winner = winner;
    }

    public Champion getLoser() {
        return loser;
    }

    public void setLoser(Champion loser) {
        this.loser = loser;
    }
}
