package com.mycompany.controller;

import com.mycompany.model.Champion;
import com.mycompany.model.GameMatch;
import com.mycompany.repository.ChampionRepository;
import com.mycompany.repository.GameMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(path = "/matches")
public class GameMatchController {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private GameMatchRepository gameMatchRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllMatches() {
        Iterable<GameMatch> matches = gameMatchRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("matches", matches);
        modelAndView.setViewName("matches");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addMatch")
    @ResponseBody
    public ModelAndView getMatch() {
        GameMatch match = new GameMatch();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("match", match);
        modelAndView.setViewName("addMatch");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addMatch")
    public String addMatch(@ModelAttribute("match") GameMatch match) {
        Champion winner = championRepository.findByName(match.getWinner().getName());
        Champion loser = championRepository.findByName(match.getLoser().getName());
        match.setWinner(winner);
        match.setLoser(loser);
        match.setMatchDate(new Date());
        gameMatchRepository.save(match);

        return "redirect:/matches";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteMatch/{matchId}")
    @ResponseBody
    public ModelAndView deleteMatch(@PathVariable("matchId") Long matchId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("matchId", matchId);
        modelAndView.setViewName("deleteMatchModal");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteMatch/{matchId}")
    public String deleteMatchModal(@PathVariable("matchId") Long matchId) {
        gameMatchRepository.deleteById(matchId);

        return "redirect:/matches";
    }

}
