package com.vinaenter.dao;

import com.vinaenter.mapper.NewMapper;
import com.vinaenter.model.NewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class NewDao {

    @Autowired private JdbcTemplate jdbcTemplate;

    public List<NewModel> findAll(){
        String sql = "select * from new inner join category on cid = cat_id";
        return jdbcTemplate.query(sql,new NewMapper());
    }
    public NewModel findOneById(int id){
        String sql = "select * from new inner join category on cid = cat_id where nid=?";
        return jdbcTemplate.queryForObject(sql, new NewMapper(), id);
    }

    public List<NewModel> findAllByCatId(int id){
        String sql = "select * from new inner join category on cid = cat_id where cat_id = ?";
        return jdbcTemplate.query(sql,new NewMapper(),id);
    }

    public long insertNew(NewModel newModel){
        newModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
        String sql = "insert into new(nname,sortdescriptor,title,createDate,cat_id) values (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "nid" });
            ps.setString(1,newModel.getName());
            ps.setString(2,newModel.getSortdescriptor());
            ps.setString(3,newModel.getTitle());
            ps.setTimestamp(4,newModel.getCreateDate());
            ps.setInt(5,newModel.getCat().getId());
            return ps;
        },keyHolder);
        return keyHolder.getKey().longValue();
    }
}
