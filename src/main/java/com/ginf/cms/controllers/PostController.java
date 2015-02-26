package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Post;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adnane on 03/02/2015.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, @ActiveUser User user, ModelMap model) throws Exception {
        Post post = postService.findOne(id);

        if (post == null) {
            throw new Exception("Post not found");
        }
        model.addAttribute("post", post);
        model.addAttribute("user", user);

        return "articles/single";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String destroy(@PathVariable Integer id) throws Exception {
        Post post = postService.findOne(id);
        if (post == null)
            throw new Exception("Post does not exist");

        postService.delete(post);

        return "redirect:/" + post.getClass().getSimpleName().toLowerCase() + "/all/page/1";
    }
}
