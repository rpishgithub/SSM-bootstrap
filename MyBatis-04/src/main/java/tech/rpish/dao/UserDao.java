package tech.rpish.dao;

import tech.rpish.po.User;

public interface UserDao {
    public User findUserById(Integer id);
}
