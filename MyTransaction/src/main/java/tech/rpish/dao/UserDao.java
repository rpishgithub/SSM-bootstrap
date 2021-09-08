package tech.rpish.dao;

import tech.rpish.bean.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    public User findUserById(int id);

    public List<User> findAllUser();

    public void transfer(String outUser,String inUser,Integer credit);
}
