package com.vinaenter.mapper;

import com.vinaenter.model.CategoryModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryModel cat = new CategoryModel();
        cat.setId(rs.getInt("cid"));
        cat.setName(rs.getString("cname"));
        return cat;
    }
}
