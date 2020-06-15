package com.marketPlace.dao;

import com.marketPlace.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User getById(int id);
    void delete(int id);
    void update(User user);
    List<User> findAll();
}
