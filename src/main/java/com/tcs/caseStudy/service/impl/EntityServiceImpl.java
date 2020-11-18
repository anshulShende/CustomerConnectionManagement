package com.tcs.caseStudy.service.impl;

import com.tcs.caseStudy.dao.EntityDAO;
import com.tcs.caseStudy.dto.database.EntityDTO;
import com.tcs.caseStudy.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityDAO entityDAO;

    @Override
    public EntityDTO authenticateEntity(String email, String password, String role) throws Exception {
        List<EntityDTO> entityDTO = entityDAO.getEntities(email,password,role);
        if(entityDTO.size()!=1){
            throw new Exception("Entity Does Not Exist Or Invalid Entity Credentials");
        }
        return entityDTO.get(0);
    }

    @Override
    public List<EntityDTO> getAllEntities() {
        return null;
    }
}
