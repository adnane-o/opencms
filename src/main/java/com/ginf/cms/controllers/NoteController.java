package com.ginf.cms.controllers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.Category;
import com.ginf.cms.entities.Note;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.ICategoryService;
import com.ginf.cms.services.INoteService;
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

import java.util.Date;
import java.util.List;

/**
 * Created by Adnane on 03/02/2015.
 */
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private INoteService noteService;
    @Autowired
    private IPostService postService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/all/page/{pageNumber}", method = RequestMethod.GET)
    public String index(@PathVariable Integer pageNumber, @ActiveUser User user, ModelMap model) {
        Page<Note> pageArticles = noteService.findAllNew(pageNumber);
        List<Note> articles = pageArticles.getContent();

        int current = pageArticles.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, pageArticles.getTotalPages());

        model.addAttribute("notes", articles);
        model.addAttribute("baseUrl", "/article/all/page/");
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("total", pageArticles.getTotalPages());

        model.addAttribute("action", "index");
        model.addAttribute("type", "note");

        return "notes/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("note") Note note, @ActiveUser User user, ModelMap model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("action", "Create");
        model.addAttribute("type", "note");

        return "notes/create";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap model) throws Exception {
        List<Category> categories = categoryService.findAll();
        Note note = noteService.findOne(id);

        if (note == null)
            throw new Exception("Note not found");

        model.addAttribute("categories", categories);
        model.addAttribute("note", note);

        model.addAttribute("action", "Update");
        model.addAttribute("type", "note");

        return "notes/create";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("note") Note note, BindingResult bindResult, ModelMap model) throws Exception {
        note.getCategories().removeIf(c -> c.getId() == null);

        note = (Note) postService.update(note);

        return "redirect:/note/{id}/update";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@ActiveUser User user, @ModelAttribute("note") Note note, BindingResult bindResult, ModelMap model) {
        //check for uncheked bject
        note.getCategories().removeIf(c -> c.getId() == null);
        note.setAuthor(user);
        note.setDate(new Date());
        note.setCommentsState(false);
        postService.save(note);

        return "redirect:create";
    }

    @RequestMapping(value = "/{id}/restore", method = RequestMethod.GET)
    public String version(@PathVariable Integer id, ModelMap model) throws Exception {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Note note = (Note) noteService.findOne(id);
        model.addAttribute("note", note);
        if (note == null)
            throw new Exception("Note not found");

        model.addAttribute("action", "Restore");
        model.addAttribute("type", "note");

        return "notes/create";
    }

    @RequestMapping(value = "/{id}/restore", method = RequestMethod.POST)
    public String restore(@PathVariable Integer id, ModelMap model) throws Exception {
        Note note = noteService.findOne(id);
        if (note == null)
            throw new Exception("Note not found");
        note = (Note) postService.restore(note);

        model.addAttribute("id", note.getId());

        return "redirect:/note/{id}/update";
    }
}
