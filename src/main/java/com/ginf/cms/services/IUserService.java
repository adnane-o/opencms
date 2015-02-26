package com.ginf.cms.services;

import com.ginf.cms.entities.User;
import org.springframework.data.domain.Page;

/**
 * Created by Adnane on 26/01/2015.
 */
public interface IUserService {
    User save(User user);

    User update(User user) throws Exception;

    User findOne(Integer id);

    User findOne(User user) throws Exception;

    Page<User> findAll(Integer pageNumber);

    void delete(User user);
}
