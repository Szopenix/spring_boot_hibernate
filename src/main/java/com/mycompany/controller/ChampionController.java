package com.mycompany.controller;

import com.mycompany.mapper.ChampionMapper;
import com.mycompany.model.Champion;
import com.mycompany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/champions")
public class ChampionController {

    @Autowired
    private ChampionMapper championMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Champion> getAllChampions() {
        return championMapper.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getChampionById/{id}")
    @ResponseBody
    public Champion getChampionById(@PathVariable("id") long id) {
        return championMapper.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getChampionByName/{championName}")
    @ResponseBody
    public Champion getChampionByName(@PathVariable("championName") String championName) {
        return championMapper.findOneByName(championName);
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
        championMapper.addChampion(champion);
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
        championMapper.updateChampion(champion);
        return "Updated";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteChampion/{id}")
    @ResponseBody
    public String deleteChampion(@PathVariable("id") long id) {
        championMapper.deleteById(id);
        return "deletedChampion";
    }

}
