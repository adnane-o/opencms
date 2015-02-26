package com.ginf.cms.services;

import com.ginf.cms.entities.Article;
import org.springframework.data.domain.Page;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface IArticleService {
    Article save(Article article);

    Article findOne(Integer id);

    Page<Article> findAll(Integer pageNumber);

    Page<Article> findAllNew(Integer pageNumber);

    Page<Article> findAllPublic(Integer pageNumber);

    Article update(Article article) throws Exception;
}
