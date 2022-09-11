package com.gizatullin.spring.springboot.spring_course_springboot.controller;


import com.gizatullin.spring.springboot.spring_course_springboot.model.User;
import com.gizatullin.spring.springboot.spring_course_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findAll(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("user", users);
        return "users";
    }

    @GetMapping("/add")
    public String toAdd(Model model) { //Model model
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping()
    public String addUser (@ModelAttribute("user") User user) {   //@ModelAttribute("user") было тут
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user";
    }



    @DeleteMapping  ("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }



    @GetMapping("/{id}/edit")
    public String editUsers(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }
    @PostMapping("/{id}")
    public String update (@ModelAttribute ("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }


}
