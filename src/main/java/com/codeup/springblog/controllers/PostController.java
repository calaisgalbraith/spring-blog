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
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String showCreateForm(Model model) {
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body, Model model) {
        Post post = new Post(title, body, userDao.getById(1L));
        postDao.save(post);
        return "posts/index";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("id", postDao.getById(id).getId());
        return "/posts/edit";
    }

    @PostMapping(path = "/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, @RequestParam(name = "title") String title,
                               @RequestParam(name = "body") String body){
        Post edited = new Post(id, title, body);
        postDao.save(edited);
        return "redirect:/posts";
    }


    @GetMapping(path = "/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }

}
