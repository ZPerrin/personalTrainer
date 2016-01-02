package com.pt.web.controller;

import com.pt.persistence.entity.User;
import com.pt.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "index";
    }

    @RequestMapping(path="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable Integer id) {

        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(path="/user/emailOrName/{emailOrName}", method = RequestMethod.GET)
    @ResponseBody
    public User getByEmailOrName(@PathVariable String emailOrName) {
        User user = userRepository.findByUserName(emailOrName);
        return user;
    }
}
