package com.ginf.cms.repositories;

import com.ginf.cms.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnane on 30/01/2015.
 */
@Repository("postRepository")
public interface IPostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAllByPublishedAndNewVersion(Boolean published, Integer newVersion, Pageable pageable);

    Page<Post> findAllByNewVersion(Integer newVersion, Pageable pageable);
}
