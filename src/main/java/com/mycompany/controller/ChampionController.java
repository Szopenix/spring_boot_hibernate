package com.mycompany.controller;

import com.mycompany.model.GameMatch;
import com.mycompany.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping(path = "/champions")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @RequestMapping(method = RequestMethod.GET, path = "/{championId}/{userId}")
    @ResponseBody
    private ModelAndView getMatchHistory(@PathVariable("championId") Long championId,
                                         @PathVariable("userId") Long userId) {
        Collection<GameMatch> allMatches = championService.getAllMatchesForChampion(championId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("matches", allMatches);
        modelAndView.addObject("championId", championId);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName("pages/championMatches");

        return modelAndView;
    }

}
