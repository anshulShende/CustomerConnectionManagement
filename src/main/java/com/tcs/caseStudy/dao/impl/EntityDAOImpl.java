package com.tcs.caseStudy.dao.impl;

import com.tcs.caseStudy.dao.EntityDAO;
import com.tcs.caseStudy.dto.database.EntityDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntityDAOImpl extends SqlSessionDaoSupport implements EntityDAO {

    @Autowired
    public EntityDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<EntityDTO> getEntities(Integer id, String email, String password, String role) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("id", id);
        inputMap.put("email", email);
        inputMap.put("password", password);
        inputMap.put("role", role);
        return getSqlSession().selectList("entity.getEntityDetails", inputMap);
    }

    @Override
    public void insertEntity(EntityDTO entityDTO) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("name", entityDTO.getName());
        inputMap.put("phone", entityDTO.getPhone());
        inputMap.put("email", entityDTO.getEmail());
        inputMap.put("gender", entityDTO.getGender());
        inputMap.put("role", entityDTO.getRole());
        inputMap.put("password", entityDTO.getPassword());
        getSqlSession().insert("entity.insertEntityDetail", inputMap);
    }

    @Override
    public void updateEntity(EntityDTO entityDTO) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("name", entityDTO.getName());
        inputMap.put("phone", entityDTO.getPhone());
        inputMap.put("email", entityDTO.getEmail());
        inputMap.put("gender", entityDTO.getGender());
        inputMap.put("role", entityDTO.getRole());
        inputMap.put("password", entityDTO.getPassword());
        getSqlSession().update("entity.updateEntity", inputMap);
    }

    @Override
    public void deleteEntity(int id) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("id", id);
        getSqlSession().delete("entity.deleteEntity", inputMap);
    }
}
