package com.pt.controller;

import com.pt.config.SpringRootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Saltheart on 7/20/2015.
 */
@Controller
public class IndexController {

    @Autowired
    SpringRootConfig.MyClass myClass;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return myClass.getText();
    }
}
