package com.ginf.cms.services;

import com.ginf.cms.entities.Note;
import org.springframework.data.domain.Page;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface INoteService {
    Note save(Note note);

    Note findOne(Integer id);

    Page<Note> findAll(Integer pageNumber);

    Page<Note> findAllNew(Integer pageNumber);

    Page<Note> findAllPublic(Integer pageNumber);

    Note update(Note note) throws Exception;
}
