package com.marketPlace.dao;

import com.marketPlace.entity.User;
import com.marketPlace.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name, email, age) values(?,?,?)";
        jdbcTemplate.update(sql, user.getName(),user.getEmail(),user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM user where id = ?";
        return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(User user) {
       String sql = "UPDATE user SET name = ?, email = ?, age = ? where id = ?";
       jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getAge(),user.getId());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
