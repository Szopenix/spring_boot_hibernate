package com.mycompany.mapper;

import com.mycompany.model.Champion;
import com.mycompany.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "champions", column = "id", javaType = List.class, many = @Many(select = "getAllChampions"))
    })
    List<User> findAll();

    @Select("SELECT * FROM USER WHERE id=#{userId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "champions", column = "id", javaType = List.class, many = @Many(select = "getAllChampions"))
    })
    User findOneById(long userId);

    @Select("SELECT * FROM USER WHERE nick_name=#{userName}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "champions", column = "id", javaType = List.class, many = @Many(select = "getAllChampions"))
    })
    User findOneByName(String userName);

    @Select("SELECT * FROM CHAMPION WHERE user_id_fk=#{user_id}")
    List<Champion> getAllChampions(long user_id);

    @Delete("DELETE FROM USER where id=#{id}")
    void deleteById(long id);

    @Insert("INSERT INTO USER(nick_name,first_name,last_name,email) VALUES(#{nickName},#{firstName},#{lastName},#{email})")
    void addUser(User user);

    @Update("UPDATE USER SET nick_name=#{nickName}, first_name=#{firstName}, last_name=#{lastName}, email=#{email} WHERE id=#{id}")
    void updateUser(User user);

}
