package com.ginf.cms.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Adnane on 03/02/2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/")
    public String index() {
        return "dashboard";
    }
}