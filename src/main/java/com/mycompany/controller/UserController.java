package com.mycompany.controller;


import com.mycompany.mapper.UserMapper;
import com.mycompany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userMapper.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUserById/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") long userId) {
        return userMapper.findOneById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUserByName/{userName}")
    @ResponseBody
    public User getUserByName(@PathVariable("userName") String userName) {
        return userMapper.findOneByName(userName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addUser")
    @ResponseBody
    public String addUser(@RequestParam String nickName,
                          @RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email) {
        User user = new User();
        user.setNickName(nickName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userMapper.addUser(user);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestParam long userId,
                             @RequestParam String nickName,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email) {
        User user = new User();
        user.setId(userId);
        user.setNickName(nickName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userMapper.updateUser(user);
        return "Updated";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") long id) {
        userMapper.deleteById(id);
        return "deletedUser";
    }

}
