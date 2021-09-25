package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        List posts = new ArrayList();
        Post p1 = new Post("title1", "body1");
        Post p2 = new Post("title2", "body2");
        posts.add(p1);
        posts.add(p2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        Post post = new Post("title", "body");
        model.addAttribute("post", post);
        return "posts/show";
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
