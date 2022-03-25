package com.aac.controllers;

import com.aac.entity.People;
import com.aac.model.Role;
import com.aac.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/registration")
    public String newPerson(@ModelAttribute("person") People People) {
        return "registration";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid People person,
                         BindingResult bindingResult, Map<String, Object> model) {
        People userFromDb = peopleRepository.findByUsername(person.getUsername());

        if (bindingResult.hasErrors())
            return "registration";

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        person.setActive(true);
        person.setRoles(Collections.singleton(Role.USER));
        person.setReputation(BigInteger.valueOf(0));
        peopleRepository.save(person);
        return "redirect:/login";
    }
}
