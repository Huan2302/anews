package com.vinaenter.dao;

import com.vinaenter.mapper.CategoryMapper;
import com.vinaenter.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @Autowired private JdbcTemplate jdbcTemplate;

    public List<CategoryModel> findAll(){
        String sql = "select * from category";
        return jdbcTemplate.query(sql,new CategoryMapper());
    }


}
