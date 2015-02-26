package com.ginf.cms.repositories;

import com.ginf.cms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnane on 26/01/2015.
 */
@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Integer> {
}