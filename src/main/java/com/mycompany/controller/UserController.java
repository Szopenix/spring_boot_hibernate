package com.mycompany.controller;


import com.mycompany.model.Champion;
import com.mycompany.model.User;
import com.mycompany.repository.ChampionRepository;
import com.mycompany.repository.GameMatchRepository;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private GameMatchRepository gameMatchRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(ModelAndView model) {
        List<User> users = userRepository.findAll();
        model.addObject("users", users);
        model.setViewName("users");
        return model;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    @ResponseBody
    public ModelAndView getUserById(@PathVariable("userId") long userId) {
        User user = userRepository.findById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}/champions")
    @ResponseBody
    public ModelAndView getAllChampions(@PathVariable("userId") Long userId) {
        Collection<Champion> champions = championRepository.findByUserId(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("champions", champions);
        modelAndView.setViewName("champions");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}/addChampion")
    @ResponseBody
    public ModelAndView getChampion(@PathVariable("userId") Long userId) {
        Champion champion = new Champion();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("champion", champion);
        modelAndView.setViewName("addChampion");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{userId}/addChampion")
    public String addChampion(@ModelAttribute("champion") Champion champion, @PathVariable("userId") long userId) {
        User user = new User();
        user.setId(userId);
        champion.setUser(user);
        championRepository.save(champion);
        return "redirect:/users/" + userId + "/champions";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}/editChampion/{championId}")
    @ResponseBody
    public ModelAndView getEditedChampion(@PathVariable("userId") Long userId,
                                          @PathVariable("championId") Long championId) {
        Champion champion = new Champion();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("championId", championId);
        modelAndView.addObject("champion", champion);
        modelAndView.setViewName("editChampion");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{userId}/editChampion/{championId}")
    public String editChampion(@ModelAttribute("champion") Champion champion,
                               @PathVariable("userId") Long userId,
                               @PathVariable("championId") Long championId) {
        champion.setId(championId);
        User user = new User();
        user.setId(userId);
        champion.setUser(user);
        championRepository.save(champion);
        return "redirect:/users/" + userId + "/champions";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}/deleteChampion/{championId}")
    @ResponseBody
    public ModelAndView deleteChampion(@PathVariable("userId") Long userId,
                                       @PathVariable("championId") Long championId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("championId", championId);
        modelAndView.setViewName("deleteChampionModal");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{userId}/deleteChampion/{championId}")
    public String deleteChampionModal(@PathVariable("userId") Long userId,
                                      @PathVariable("championId") Long championId) {
        gameMatchRepository.deleteByWinnerId(championId);
        gameMatchRepository.deleteByLoserId(championId);
        championRepository.deleteById(championId);
        return "redirect:/users/" + userId + "/champions";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUserByName/{userName}")
    @ResponseBody
    public User getUserByName(@PathVariable("userName") String userName) {
        return userRepository.findByName(userName);
    }

}
