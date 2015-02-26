package com.ginf.cms.services;

import com.ginf.cms.entities.Comment;
import com.ginf.cms.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by Adnane on 12/02/2015.
 */
@Service("commentService")
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findOne(Integer id) {
        return null;
    }

    @Override
    public Page<Comment> findAll(Integer pageNumber) {
        return null;
    }

    @Override
    public Comment update(Comment comment) throws Exception {
        return null;
    }

    @Override
    public Comment delete(Comment comment) {
        return null;
    }
}
