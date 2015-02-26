package com.ginf.cms.services;

import com.ginf.cms.entities.Category;
import com.ginf.cms.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adnane on 11/02/2015.
 */
@Service("categoryService")
public class CategoryService implements ICategoryService {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category findOne(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) throws Exception {
        Category old = categoryRepository.findOne(category.getId());

        if (old == null)
            throw new Exception("Category does not exist");
        old.setName(category.getName());
        return categoryRepository.save(old);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Page<Category> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "id");
        return categoryRepository.findAll(request);
    }
}
