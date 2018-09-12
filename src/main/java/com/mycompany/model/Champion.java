package com.mycompany.model;

import java.util.List;

public class Champion {

    private long id;
    private double attackPower;
    private double abilityPower;
    private String name;
    private User user;
    private List<GameMatch> gameMatches;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getAbilityPower() {
        return abilityPower;
    }

    public void setAbilityPower(double abilityPower) {
        this.abilityPower = abilityPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<GameMatch> getGameMatches() {
        return gameMatches;
    }

    public void setGameMatches(List<GameMatch> gameMatches) {
        this.gameMatches = gameMatches;
    }
}
