package com.mycompany.model;

public class GameMatch {

    private long id;
    private Champion winner;
    private Champion loser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
