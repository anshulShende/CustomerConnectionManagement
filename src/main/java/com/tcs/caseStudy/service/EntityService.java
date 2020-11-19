package com.tcs.caseStudy.service;


import com.tcs.caseStudy.domain.EntityRole;
import com.tcs.caseStudy.dto.client.EntityClientDTO;
import com.tcs.caseStudy.dto.database.EntityDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntityService {

    EntityDTO authenticateEntity(String email, String password, EntityRole role) throws Exception;

    List<EntityDTO> getAllEntities();

    EntityDTO fetchEntity(Integer id) throws Exception;

    @Transactional
    void registerEntity(EntityClientDTO entity) throws Exception;

    void deleteEntity(Integer id, EntityRole role) throws Exception;

}
