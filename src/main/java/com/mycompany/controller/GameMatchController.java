package com.mycompany.controller;

import com.mycompany.model.Champion;
import com.mycompany.model.GameMatch;
import com.mycompany.repository.GameMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/matches")
public class GameMatchController {

    @Autowired
    private GameMatchRepository gameMatchRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<GameMatch> getAllMatches() {
        return gameMatchRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getMatchById/{id}")
    @ResponseBody
    public Optional<GameMatch> getMatchById(@PathVariable("id") long id) {
        return gameMatchRepository.findById(id);
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
        gameMatchRepository.save(gameMatch);
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
        gameMatchRepository.save(gameMatch);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteMatch/{id}")
    @ResponseBody
    public String deleteMatch(@PathVariable("id") long id) {
        gameMatchRepository.deleteById(id);
        return "deletedMatch";
    }

}
