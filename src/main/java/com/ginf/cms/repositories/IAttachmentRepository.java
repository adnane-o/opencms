package com.ginf.cms.repositories;

import com.ginf.cms.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adnane on 30/01/2015.
 */
public interface IAttachmentRepository extends JpaRepository<Attachment, Integer> {

}