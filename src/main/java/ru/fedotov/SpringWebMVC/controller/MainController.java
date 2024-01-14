package ru.fedotov.SpringWebMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String helloPage(){
        return "acceptedPage";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
