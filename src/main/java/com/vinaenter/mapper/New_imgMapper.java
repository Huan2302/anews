package com.vinaenter.mapper;

import com.vinaenter.model.New_ImgModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class New_imgMapper implements RowMapper<New_ImgModel> {
    @Override
    public New_ImgModel mapRow(ResultSet resultSet, int i) throws SQLException {
        New_ImgModel newImgModel = new New_ImgModel();
        newImgModel.setId(resultSet.getInt("iid"));
        newImgModel.setName(resultSet.getString("iname"));
        newImgModel.setNew_id(resultSet.getInt("new_id"));
        return newImgModel;
    }
}
