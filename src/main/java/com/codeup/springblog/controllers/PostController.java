package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String createForm(Model model) {
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@PathVariable String title, @PathVariable String body, Model model) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "posts/index";
    }
}
