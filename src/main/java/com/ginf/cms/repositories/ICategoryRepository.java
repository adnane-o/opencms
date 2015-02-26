package com.ginf.cms.repositories;

import com.ginf.cms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnane on 30/01/2015.
 */
@Repository("categoryRepository")
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
