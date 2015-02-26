package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Category;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.ICategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/all/page/{pageNumber}", method = RequestMethod.GET)
    public String index(@PathVariable Integer pageNumber, @ActiveUser User user, ModelMap model) {
        Page<Category> pageCategories = categoryService.findAll(pageNumber);
        List<Category> categories = pageCategories.getContent();

        int current = pageCategories.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pageCategories.getTotalPages());
        model.addAttribute("categories", categories);
        model.addAttribute("baseUrl", "/category/all/page/");
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("total", pageCategories.getTotalPages());

        model.addAttribute("action", "index");
        model.addAttribute("type", "category");

        return "categories/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("category") Category category, @ActiveUser User user, ModelMap model) {

        model.addAttribute("action", "Create");
        model.addAttribute("type", "category");

        return "categories/create";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap model) throws Exception {
        Category category = categoryService.findOne(id);
        if (category == null) {
            throw new Exception("Category not found");
        }
        model.addAttribute("category", category);

        model.addAttribute("action", "Update");
        model.addAttribute("type", "category");

        return "categories/create";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("category") Category category, BindingResult bindResult, ModelMap model) throws Exception {
        category = categoryService.update(category);
        return "redirect:/category/{id}/update";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@ModelAttribute("category") Category category, @ActiveUser User user) {
        category = categoryService.save(category);
        return "redirect:/category/" + category.getId();
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String destroy(@PathVariable Integer id) throws Exception {
        Category category = categoryService.findOne(id);
        if (category == null)
            throw new Exception("Category does not exist");

        categoryService.delete(category);

        return "category/all/page/1";
    }
}
