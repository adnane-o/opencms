package com.ginf.cms.repositories;

import com.ginf.cms.entities.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnane on 30/01/2015.
 */
@Repository("noteRepository")
public interface INoteRepository extends JpaRepository<Note, Integer> {
    Page<Note> findAllByPublishedAndNewVersion(Boolean published, Integer newVersion, Pageable pageable);

    Page<Note> findAllByNewVersion(Integer newVersion, Pageable pageable);
}
