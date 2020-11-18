package com.tcs.caseStudy.dao;

import com.tcs.caseStudy.dto.database.EntityDTO;

import java.util.List;

public interface EntityDAO {

    List<EntityDAO> getEntities(String email, String password, String role);

    void insertEntity(EntityDTO entityDTO);

    void updateEntity(EntityDTO entityDTO);

    void deleteEntity(int id);
}
