package com.tcs.caseStudy.service;


import com.tcs.caseStudy.dto.database.EntityDTO;

import java.util.List;

public interface EntityService {

    EntityDTO authenticateEntity(String email, String password, String role) throws Exception;

    List<EntityDTO> getAllEntities();

}
