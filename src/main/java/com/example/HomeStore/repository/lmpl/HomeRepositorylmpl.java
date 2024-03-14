package com.example.HomeStore.repository.lmpl;

import com.example.HomeStore.model.entity.Home;
import com.example.HomeStore.repository.HomeStoreRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HomeRepositorylmpl implements HomeStoreRepository {
    private  final JdbcTemplate jdbcTemplate;

    public HomeRepositorylmpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Home> getAll() {
        String query = "select i.id, i.area, i.rooms, i.price, i.location, i.status from home i";
        RowMapper<Home> rowMapper =  new RowMapper<Home>() {
            @Override
            public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildHome(rs);
            }
        };

        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Home getById(Long id) {
       String  query = "select i.id, i.area, i.rooms, i.price, i.location, i.status from home i where id = ?";


       RowMapper<Home> rowMapper = new RowMapper<Home>() {
           @Override
           public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
               return buildHome(rs);
           }
       };
       List<Home>homeList = jdbcTemplate.query(query,rowMapper, id);
       if (homeList.isEmpty()){
           return  Home.builder().build();
       }
       return homeList.get(0);

    }

    @Override
    public boolean insert(Home home) {
      String query = "insert into home( area, rooms, price, location, status) values(?, ?, ?, ?, ?)";

      int res =  jdbcTemplate.update(query, home.getArea(),home.getRooms() ,home.getPrice(), home.getLocation(), home.getStatus());

        return res!=0;
    }

    @Override
    public boolean update(Home home) {
       String query = "update home i set i.area =?, i.rooms=?, i.price=?, i.location =?, i.status =? where id =?";
       int res = jdbcTemplate.update(query, home.getArea(), home.getRooms() ,home.getPrice(), home.getLocation(), home.getStatus(), home.getId());
       return res!=0;
    }

    @Override
    public boolean delete(Long id) {
       String query = "delete from home i where i.id = ?";
       int res = jdbcTemplate.update(query,id);

        return res!=0;
    }


    private Home  buildHome(ResultSet rs) throws SQLException{
        return Home.builder()
                .id(rs.getLong("id"))
                .area(rs.getInt("area"))
                .rooms(rs.getInt("rooms"))
                .price(rs.getInt("price"))
                .location(rs.getString("location"))
                .status(rs.getString("status"))
                .build();
    }

}
