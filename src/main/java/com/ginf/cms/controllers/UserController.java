package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Role;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Adnane on 07/02/2015.
 */
@Controller
@RequestMapping("/user")
//@PreAuthorize("isAnonymous()")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/all/page/{pageNumber}", method = RequestMethod.GET)
    public String index(@PathVariable Integer pageNumber, @ActiveUser User user, ModelMap model) {
        Page<User> pageUsers = userService.findAll(pageNumber);
        List<User> users = pageUsers.getContent();
        int current = pageUsers.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pageUsers.getTotalPages());
        model.addAttribute("users", users);
        model.addAttribute("baseUrl", "/user/all/page/");
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("total", pageUsers.getTotalPages());

        model.addAttribute("action", "index");
        model.addAttribute("type", "user");

        return "users/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@ModelAttribute("user") User user) {
        Role role = new Role();
        role.setAuthority("ROLE_USER");
        role.setUser(user);
        user.getRoles().add(role);
        userService.save(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap model) throws Exception {
        User user = userService.findOne(id);
        if (user == null)
            throw new Exception("User not found");

        model.addAttribute("user", user);

        System.out.print(user.getRoles());


        model.addAttribute("action", "Update");
        model.addAttribute("type", "user");
        model.addAttribute("roles", Role.Authority.values());

        return "users/update";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user, BindingResult bindResult, ModelMap model) throws Exception {
        user.getRoles().removeIf(c -> c.getAuthority() == null);
        user = userService.update(user);
        return "redirect:/user/{id}/update";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String destroy(@PathVariable Integer id) throws Exception {
        User user = userService.findOne(id);
        if (user == null)
            throw new Exception("User does not exist");

        userService.delete(user);
        return "redirect:/user/all/page/1";
    }
}
