package com.ginf.cms.services;

import com.ginf.cms.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Adnane on 11/02/2015.
 */
public interface ICategoryService {
    Category findOne(Integer id);

    List<Category> findAll();

    Category save(Category category);

    Category update(Category category) throws Exception;

    void delete(Category category);

    public Page<Category> findAll(Integer pageNumber);
}
