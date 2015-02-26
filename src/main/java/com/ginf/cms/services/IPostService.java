package com.ginf.cms.services;

import com.ginf.cms.entities.Post;
import org.springframework.data.domain.Page;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface IPostService {
    Post save(Post post);

    Post findOne(Integer id);

    Page<Post> findAll(Integer pageNumber);

    Page<Post> findAllNew(Integer pageNumber);

    Page<Post> findAllPublic(Integer pageNumber);

    Post update(Post post) throws Exception;

    Post restore(Post post) throws Exception;

    void delete(Post post);
}
