package com.ginf.cms.repositories;

import com.ginf.cms.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnane on 30/01/2015.
 */
@Repository("articleRepository")
public interface IArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findAllByPublishedAndNewVersion(Boolean published, Integer newVersion, Pageable pageable);

    Page<Article> findAllByNewVersion(Integer newVersion, Pageable pageable);
}
