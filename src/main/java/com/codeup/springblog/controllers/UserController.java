package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/user/create")
    public String ShowCreateUserForm(Model model){
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping(path = "/user/create")
    public String createUser(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/posts";
    }

}