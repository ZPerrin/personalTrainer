package com.pt.web.controller;

import com.pt.persistence.entity.User;
import com.pt.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model) {

        User user = userRepository.findOne(1);
        model.addAttribute("user", user);

        return"index";
    }
}
