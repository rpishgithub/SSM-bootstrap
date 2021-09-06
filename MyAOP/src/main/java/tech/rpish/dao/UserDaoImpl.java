package tech.rpish.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("User Added.");
    }

    @Override
    public void deleteUser() {
        System.out.println("User Deleted.");
    }
}
