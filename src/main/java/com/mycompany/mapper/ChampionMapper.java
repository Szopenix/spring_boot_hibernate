package com.mycompany.mapper;

import com.mycompany.model.Champion;
import com.mycompany.model.GameMatch;
import com.mycompany.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChampionMapper {

    @Select("SELECT * FROM CHAMPION")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "attackPower", column = "attack_power"),
            @Result(property = "abilityPower", column = "ability_power"),
            @Result(property = "name", column = "name"),
            @Result(property = "user", column = "id", one = @One(select = "getUserById")),
            @Result(property = "gameMatches", column = "id", javaType = List.class, many = @Many(select = "getAllMatches"))
    })
    List<Champion> findAll();

    @Select("SELECT * FROM CHAMPION WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "attackPower", column = "attack_power"),
            @Result(property = "abilityPower", column = "ability_power"),
            @Result(property = "name", column = "name"),
            @Result(property = "user", column = "id", one = @One(select = "getUserById")),
            @Result(property = "gameMatches", column = "id", javaType = List.class, many = @Many(select = "getAllMatches"))
    })
    Champion findOneById(long id);

    @Select("SELECT * FROM CHAMPION WHERE name=#{championName}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "attackPower", column = "attack_power"),
            @Result(property = "abilityPower", column = "ability_power"),
            @Result(property = "name", column = "name"),
            @Result(property = "user", column = "id", one = @One(select = "getUserById")),
            @Result(property = "gameMatches", column = "id", javaType = List.class, many = @Many(select = "getAllMatches"))
    })
    Champion findOneByName(String championName);

    @Select("SELECT * FROM GAME_MATCH WHERE champion_winner_id_fk = #{championId} OR champion_loser_id_fk = #{championId}")
    List<GameMatch> getAllMatches(long championId);

    @Select("SELECT * FROM USER WHERE id=#{userId}")
    User getUserById(long userId);

    @Delete("DELETE FROM CHAMPION where id=#{id}")
    void deleteById(long id);

    @Insert("INSERT INTO CHAMPION(attack_power,ability_power,name,user_id_fk) VALUES (#{attackPower},#{abilityPower},#{name},#{user.id})")
    void addChampion(Champion champion);

    @Update("UPDATE CHAMPION SET attack_power=#{attackPower}, ability_power=#{abilityPower}, name=#{name}, user_id_fk=#{user.id} WHERE id=#{id}")
    void updateChampion(Champion champion);

}
