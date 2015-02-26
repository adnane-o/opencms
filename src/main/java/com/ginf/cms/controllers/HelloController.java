package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Post;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private IPostService postService;

    /*    @RequestMapping(method = RequestMethod.GET)
        @PreAuthorize("hasRole('ROLE_USER')")
        public String printWelcome(ModelMap model) {
    //        User user = new User();
    //        user.setName("Ali");
    //        userService.save(user);
    //
    //        System.out.println(user.getId());
            model.addAttribute("message", "Hello world!");
            return "hello";
        }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dispatch() {
        return "redirect:/home/1";
    }

    @RequestMapping(value = "/home/{pageNumber}", method = RequestMethod.GET)
    public String index(@ModelAttribute @ActiveUser User user, ModelMap model, @PathVariable Integer pageNumber) {

        Page<Post> pagePosts = postService.findAllPublic(pageNumber);
        List<Post> posts = pagePosts.getContent();

        int current = pagePosts.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pagePosts.getTotalPages());
        model.addAttribute("posts", posts);
        model.addAttribute("baseUrl", "/home/");
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("total", pagePosts.getTotalPages());

        model.addAttribute("action", "index");
        model.addAttribute("type", "category");
        return "hello/home";
    }
}