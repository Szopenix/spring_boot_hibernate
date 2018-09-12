package com.mycompany.controller;

import com.mycompany.mapper.GameMatchMapper;
import com.mycompany.model.Champion;
import com.mycompany.model.GameMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/matches")
public class GameMatchController {

    @Autowired
    private GameMatchMapper gameMatchMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<GameMatch> getAllMatches() {
        return gameMatchMapper.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getMatchById/{id}")
    @ResponseBody
    public GameMatch getMatchById(@PathVariable("id") long id) {
        return gameMatchMapper.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addMatch")
    @ResponseBody
    public String addMatch(@RequestParam long winnerId,
                           @RequestParam long loserId) {
        GameMatch gameMatch = new GameMatch();
        Champion winner = new Champion();
        winner.setId(winnerId);
        Champion loser = new Champion();
        loser.setId(loserId);
        gameMatch.setWinner(winner);
        gameMatch.setLoser(loser);
        gameMatchMapper.addChampion(gameMatch);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updateMatch")
    @ResponseBody
    public String updateMatch(@RequestParam long matchId,
                              @RequestParam long winnerId,
                              @RequestParam long loserId) {
        GameMatch gameMatch = new GameMatch();
        gameMatch.setId(matchId);
        Champion winner = new Champion();
        winner.setId(winnerId);
        Champion loser = new Champion();
        loser.setId(loserId);
        gameMatch.setWinner(winner);
        gameMatch.setLoser(loser);
        gameMatchMapper.updateChampion(gameMatch);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteMatch/{id}")
    @ResponseBody
    public String deleteMatch(@PathVariable("id") long id) {
        gameMatchMapper.deleteById(id);
        return "deletedMatch";
    }

}
