package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Article;
import com.ginf.cms.entities.Comment;
import com.ginf.cms.entities.Post;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.ICommentService;
import com.ginf.cms.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adnane on 03/02/2015.
 */
@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IPostService postService;


    @RequestMapping(value = "/post/{id}/comment", method = RequestMethod.POST)
    public String store(@ModelAttribute("comment") Comment comment, BindingResult bindingResult, ModelMap model, Article article, @PathVariable Integer id, @ActiveUser User user) throws Exception {

        Post post = postService.findOne(id);

        if (post == null)
            throw new Exception("Post not found");

        comment.setPost(post);
        comment.setUser(user);
        commentService.save(comment);

        return "redirect:/post/{id}/";
    }

}
