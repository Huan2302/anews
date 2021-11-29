package com.vinaenter.mapper;

import com.vinaenter.model.CategoryModel;
import com.vinaenter.model.NewModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel> {
    @Override
    public NewModel mapRow(ResultSet resultSet, int i) throws SQLException {
        NewModel newmodel = new NewModel();
        newmodel.setId(resultSet.getInt("nid"));
        newmodel.setName(resultSet.getString("nname"));
        newmodel.setSortdescriptor(resultSet.getString("sortdescriptor"));
        newmodel.setTitle(resultSet.getString("title"));
        newmodel.setCreateDate(resultSet.getTimestamp("createDate"));
        CategoryModel cat = new CategoryModel();
        try{
            cat.setId(resultSet.getInt("cid"));
            cat.setName(resultSet.getString("cname"));
        }catch (Exception e){
            e.getMessage();
        }
        newmodel.setCat(cat);
        return newmodel;
    }
}
