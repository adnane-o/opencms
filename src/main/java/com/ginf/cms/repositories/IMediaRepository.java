package com.ginf.cms.repositories;

import com.ginf.cms.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface IMediaRepository extends JpaRepository<Media, Integer> {
}
