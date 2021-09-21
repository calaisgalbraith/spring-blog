package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @GetMapping("/")
//    @ResponseBody
//    public String helloFromSpring(){
//        return "Hello from the world of Spring Boot";
//    }

    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWord(){
        return "Hello World";
    }


}
