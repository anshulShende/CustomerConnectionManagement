package com.tcs.caseStudy.service.impl;

import com.tcs.caseStudy.dao.EntityDAO;
import com.tcs.caseStudy.domain.EntityRole;
import com.tcs.caseStudy.dto.client.EntityClientDTO;
import com.tcs.caseStudy.dto.database.EntityDTO;
import com.tcs.caseStudy.service.EntityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityDAO entityDAO;

    @Override
    public EntityDTO authenticateEntity(String email, String password, EntityRole role) throws Exception {
        List<EntityDTO> entityDTOS = entityDAO.getEntities(null, email,password,role.toString());
        if(entityDTOS.size()!=1){
            throw new Exception("Entity Does Not Exist Or Invalid Entity Credentials");
        }
        return entityDTOS.get(0);
    }

    @Override
    public List<EntityDTO> getAllEntities() {
        return entityDAO.getEntities(null,null,null,null);
    }

    @Override
    public EntityDTO fetchEntity(Integer id) throws Exception {
        List<EntityDTO> entityDTOS = entityDAO.getEntities(id,null,null, null);
        if(entityDTOS.isEmpty()){
            throw new Exception("There is no Entity with Id " + id);
        }
        return entityDTOS.get(0);
    }

    @Override
    @Transactional
    public void registerEntity(EntityClientDTO entity) throws Exception {
        List<EntityDTO> entityDTOS = entityDAO.getEntities(null, entity.getEmail(), null, null);
        if(!entityDTOS.isEmpty()){
            throw new Exception("Another Entity with same email exists");
        }
        EntityDTO entityDTO = EntityDTO.builder().name(entity.getName()).email(entity.getEmail())
                .phone(entity.getPhone()).gender(entity.getGender()).role(entity.getRole())
                .password(entity.getPassword()).build();
        entityDAO.insertEntity(entityDTO);
    }

    @Override
    @Transactional
    public EntityDTO updateEntity(EntityClientDTO entityClientDTO, EntityRole updater) throws Exception {
        if(updater.equals(EntityRole.Manager)){
            throw new Exception("RelationShip Manager cannot update the data");
        }
        if(entityClientDTO.getId()==null){
            throw new Exception("Entity id is mandatory for updating data");
        }
        EntityDTO entityDTO = EntityDTO.builder().id(entityClientDTO.getId()).name(entityClientDTO.getName())
                .email(entityClientDTO.getEmail()).phone(entityClientDTO.getPhone()).gender(entityClientDTO.getGender())
                .role(entityClientDTO.getRole()).password(entityClientDTO.getPassword()).build();
        entityDAO.updateEntity(entityDTO);
        return entityDAO.getEntities(entityClientDTO.getId(),null,null,null).get(0);
    }

    @Override
    public void deleteEntity(Integer id, EntityRole role) throws Exception {
        if(!role.equals(EntityRole.Admin)){
            throw new Exception("Only Admins can delete Entities");
        }
        entityDAO.deleteEntity(id);
    }
}
