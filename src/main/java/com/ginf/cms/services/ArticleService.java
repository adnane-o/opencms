package com.ginf.cms.services;

import com.ginf.cms.entities.Article;
import com.ginf.cms.repositories.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Adnane on 10/02/2015.
 */
@Service("articleService")
public class ArticleService implements IArticleService {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private IArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findOne(Integer id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Page<Article> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return articleRepository.findAll(request);
    }

    @Override
    public Page<Article> findAllNew(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return articleRepository.findAllByNewVersion(null, request);
    }

    @Override
    public Page<Article> findAllPublic(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return articleRepository.findAllByPublishedAndNewVersion(true, null, request);
    }

    @Override
    public Article update(Article article) throws Exception {
        Article articleToUpdate = articleRepository.findOne(article.getId());

        if (articleToUpdate == null) {
            throw new Exception("Requested article does not exit");
        }

        if (articleToUpdate.isDifferentFrom(article)) {
            Article oldArticle = new Article();
            oldArticle.copyFrom(articleToUpdate);
            oldArticle.setNewVersion(articleToUpdate);
            oldArticle.setPublished(false);
            articleRepository.save(oldArticle);
        }

        articleToUpdate.copyFrom(article);
        articleToUpdate.setNewVersion(null);
        System.out.println(articleToUpdate.getCategories());
        articleRepository.save(articleToUpdate);


        return articleToUpdate;
    }
}
