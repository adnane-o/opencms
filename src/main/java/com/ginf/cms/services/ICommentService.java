package com.ginf.cms.services;

import com.ginf.cms.entities.Comment;
import org.springframework.data.domain.Page;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface ICommentService {
    Comment save(Comment comment);

    Comment findOne(Integer id);

    Page<Comment> findAll(Integer pageNumber);

    Comment update(Comment comment) throws Exception;

    Comment delete(Comment comment);
}
