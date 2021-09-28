package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping(path = "/posts/edit/{id}")
    public String showEditForm(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping(path = "/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }

}
