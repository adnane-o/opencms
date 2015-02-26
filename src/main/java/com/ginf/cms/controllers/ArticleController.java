package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Article;
import com.ginf.cms.entities.Category;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.IArticleService;
import com.ginf.cms.services.ICategoryService;
import com.ginf.cms.services.IPostService;
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
 * Created by Adnane on 03/02/2015.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;


    @RequestMapping(value = "/all/page/{pageNumber}", method = RequestMethod.GET)
    public String index(@PathVariable Integer pageNumber, @ActiveUser User user, ModelMap model) {
        Page<Article> pageArticles = articleService.findAllNew(pageNumber);
        List<Article> articles = pageArticles.getContent();
        int current = pageArticles.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pageArticles.getTotalPages());
        model.addAttribute("articles", articles);
        model.addAttribute("baseUrl", "/article/all/page/");
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("total", pageArticles.getTotalPages());

        model.addAttribute("action", "index");
        model.addAttribute("type", "article");

        return "articles/index";
    }

//    @RequestMapping(value = "/{id", method = RequestMethod.GET)
//    public String show(@PathVariable Integer id, @ActiveUser User user, ModelMap model) throws Exception {
//        Article article = articleService.findOne(id);
//        if (article == null) {
//            throw new Exception("Article not found");
//        }
//        model.addAttribute("article", article);
//
//        return "articles/single";
//    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("article") Article article, @ActiveUser User user, ModelMap model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("action", "Create");
        model.addAttribute("type", "article");

        return "articles/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@ActiveUser User user, @ModelAttribute("article") Article article, BindingResult bindResult, ModelMap model) {
        //check for uncheked bject
        article.getCategories().removeIf(c -> c.getId() == null);

        article.setAuthor(user);
        articleService.save(article);
        model.addAttribute("id", article.getId());

        return "redirect:/article/{id}/update";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap model) throws Exception {
        List<Category> categories = categoryService.findAll();
        Article article = articleService.findOne(id);

        model.addAttribute("categories", categories);
        model.addAttribute("article", article);

        if (article == null)
            throw new Exception("Article not found");

        model.addAttribute("action", "Update");
        model.addAttribute("type", "article");

        return "articles/create";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("article") Article article, BindingResult bindResult, ModelMap model) throws Exception {
        article.getCategories().removeIf(c -> c.getId() == null);

        article = (Article) postService.update(article);

        return "redirect:/article/{id}/update";
    }

    @RequestMapping(value = "/{id}/restore", method = RequestMethod.GET)
    public String version(@PathVariable Integer id, ModelMap model) throws Exception {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Article article = (Article) articleService.findOne(id);
        model.addAttribute("article", article);
        if (article == null)
            throw new Exception("Article not found");

        model.addAttribute("action", "Restore");
        model.addAttribute("action", "Restore");

        return "articles/create";
    }

    @RequestMapping(value = "/{id}/restore", method = RequestMethod.POST)
    public String restore(@PathVariable Integer id, ModelMap model) throws Exception {
        Article article = articleService.findOne(id);
        article = (Article) postService.restore(article);

        model.addAttribute("id", article.getId());

        return "redirect:/article/{id}/update";
    }
}
