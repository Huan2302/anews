package com.vinaenter.dao;

import com.vinaenter.mapper.New_imgMapper;
import com.vinaenter.model.New_ImgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class New_ImgDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insertImg(New_ImgModel newImgModel){
        String sql = "insert into new_img(iname,new_id) values (?,?)";
        return jdbcTemplate.update(sql,newImgModel.getName(),newImgModel.getNew_id());
    }

    public List<New_ImgModel> findNewImdByNewId(int id){
        String sql ="select * from new_img where new_id = ?";
        return jdbcTemplate.query(sql,new New_imgMapper(),id);
    }

//    public static void main(String[] args) {
//        List<New_ImgModel> list = new New_ImgDao().findNewImdByNewId(1);
//        for (New_ImgModel item:list){
//            System.out.println(item.getName());
//        }
//    }
}
