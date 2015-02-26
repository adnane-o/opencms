package com.ginf.cms.services;

import com.ginf.cms.entities.User;
import com.ginf.cms.repositories.IRoleRepository;
import com.ginf.cms.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Adnane on 26/01/2015.
 */
@Service("userService")
public class UserService implements IUserService {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        User userToUpdate = userRepository.findOne(user.getId());

        if (userToUpdate == null) {
            throw new Exception("Requested user does not exit");
        }

//        userToUpdate.getRoles().clear();
        roleRepository.delete(userToUpdate.getRoles());

        user.getRoles().forEach(r -> r.setUser(user));

        userToUpdate.copyFrom(user);
        userToUpdate.setRoles(user.getRoles());
        userRepository.save(userToUpdate);

        return userToUpdate;
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findOne(User user) throws Exception {
        if (user == null || user.getId() == null)
            throw new Exception("User does not exist");
        return userRepository.findOne(user.getId());
    }

    @Override
    public Page<User> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "id");
        return userRepository.findAll(request);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
