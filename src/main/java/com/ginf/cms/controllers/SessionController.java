package com.ginf.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adnane on 06/02/2015.
 */
@Controller
public class SessionController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String show(@ModelAttribute("") ModelMap model) {
        return "sessions/login";
    }
}
