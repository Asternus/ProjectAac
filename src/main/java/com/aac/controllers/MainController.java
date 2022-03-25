package com.aac.controllers;

import com.aac.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final PeopleRepository peopleRepository;

    @Autowired
    public MainController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/")
    public String index() {
        return "home/home";
    }

    @GetMapping("/main")
    public String main() {
        return "home/main";
    }

}
