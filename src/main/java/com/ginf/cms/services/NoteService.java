package com.ginf.cms.services;

import com.ginf.cms.entities.Note;
import com.ginf.cms.repositories.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Adnane on 10/02/2015.
 */
@Service("noteService")
public class NoteService implements INoteService {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private INoteRepository noteRepository;

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note findOne(Integer id) {
        return noteRepository.findOne(id);
    }

    @Override
    public Page<Note> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return noteRepository.findAll(request);
    }

    @Override
    public Page<Note> findAllNew(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return noteRepository.findAllByNewVersion(null, request);
    }

    @Override
    public Page<Note> findAllPublic(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return noteRepository.findAllByPublishedAndNewVersion(true, null, request);
    }

    @Override
    public Note update(Note note) throws Exception {
        note = noteRepository.findOne(note.getId());
        if (note == null)
            throw new Exception("Requested note does not exit");
        return noteRepository.save(note);
    }
}
