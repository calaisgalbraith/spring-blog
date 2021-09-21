package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String indexPage() {
        return "posts index page";
    }

    @GetMapping(path = "/posts{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id) {
        return "view an individual post";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createForm() {
        return "view form for creating a post";
    }

    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
