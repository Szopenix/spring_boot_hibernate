package com.mycompany.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private double attackPower;
    private double abilityPower;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "winner")
    private List<GameMatch> wonMatches;

    @OneToMany(mappedBy = "loser")
    private List<GameMatch> lostMatches;

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

    public List<GameMatch> getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(List<GameMatch> wonMatches) {
        this.wonMatches = wonMatches;
    }

    public List<GameMatch> getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(List<GameMatch> lostMatches) {
        this.lostMatches = lostMatches;
    }
}
