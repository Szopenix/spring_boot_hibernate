package com.mycompany.controller;


import com.mycompany.model.User;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUserById/{userId}")
    @ResponseBody
    public Optional<User> getUserById(@PathVariable("userId") long userId) {
        return userRepository.findById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUserByName/{userName}")
    @ResponseBody
    public User getUserByName(@PathVariable("userName") String userName) {
        return userRepository.findByName(userName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addUser")
    @ResponseBody
    public String addUser(@RequestParam String nickName,
                          @RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email) {
        User user = new User();
        user.setName(nickName);
        user.setEmail(email);
        userRepository.save(user);
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
        user.setName(nickName);
        user.setEmail(email);
        userRepository.save(user);
        return "Updated";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "deletedUser";
    }

}
