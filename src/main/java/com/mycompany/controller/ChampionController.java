package com.mycompany.controller;

import com.mycompany.model.Champion;
import com.mycompany.model.User;
import com.mycompany.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping(path = "/champions")
public class ChampionController {

    @Autowired
    private ChampionRepository championRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Champion> getAllChampions() {
        return championRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getChampionById/{id}")
    @ResponseBody
    public Optional<Champion> getChampionById(@PathVariable("id") long id) {
        return championRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getChampionByName/{championName}")
    @ResponseBody
    public Champion getChampionByName(@PathVariable("championName") String championName) {
        return championRepository.findByName(championName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addChampion")
    @ResponseBody
    public String addChampion(@RequestParam double attackPower,
                              @RequestParam double abilityPower,
                              @RequestParam String name,
                              @RequestParam long userId) {
        Champion champion = new Champion();
        champion.setAttackPower(attackPower);
        champion.setAbilityPower(abilityPower);
        champion.setName(name);
        User user = new User();
        user.setId(userId);
        champion.setUser(user);
        championRepository.save(champion);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updateChampion")
    @ResponseBody
    public String updateChampion(@RequestParam long championId,
                                 @RequestParam double attackPower,
                                 @RequestParam double abilityPower,
                                 @RequestParam String name,
                                 @RequestParam long userId) {
        Champion champion = new Champion();
        champion.setId(championId);
        champion.setAttackPower(attackPower);
        champion.setAbilityPower(abilityPower);
        champion.setName(name);
        User user = new User();
        user.setId(userId);
        champion.setUser(user);
        championRepository.save(champion);
        return "Updated";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteChampion/{id}")
    @ResponseBody
    public String deleteChampion(@PathVariable("id") long id) {
        championRepository.deleteById(id);
        return "deletedChampion";
    }

}
