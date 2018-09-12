package com.mycompany.mapper;

import com.mycompany.model.Champion;
import com.mycompany.model.GameMatch;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameMatchMapper {

    @Select("SELECT * FROM GAME_MATCH")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "winner", column = "id", one = @One(select = "getChampionById")),
            @Result(property = "loser", column = "id", one = @One(select = "getChampionById"))
    })
    List<GameMatch> findAll();

    @Select("SELECT * FROM GAME_MATCH WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "winner", column = "id", one = @One(select = "getChampionById")),
            @Result(property = "loser", column = "id", one = @One(select = "getChampionById"))
    })
    GameMatch findOneById(long id);

    @Select("SELECT * FROM CHAMPION WHERE id=#{championId}")
    Champion getChampionById(long championId);

    @Delete("DELETE FROM GAME_MATCH where id=#{id}")
    void deleteById(long id);

    @Insert("INSERT INTO GAME_MATCH(id,champion_winner_id_fk,champion_loser_id_fk) VALUES (#{id},#{winner.id},#{loser.id})")
    void addChampion(GameMatch champion);

    @Update("UPDATE GAME_MATCH SET id=#{id}, champion_winner_id_fk=#{winner.id}, champion_loser_id_fk=#{loser.id} WHERE id=#{id}")
    void updateChampion(GameMatch champion);
}
