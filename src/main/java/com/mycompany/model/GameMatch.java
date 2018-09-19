package com.mycompany.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class GameMatch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Date matchDate;

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

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
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
