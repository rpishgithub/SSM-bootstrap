package tech.rpish.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tech.rpish.bean.User;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(username,password) value(?,?)";
        Object[] obj = new Object[]{
                user.getUsername(),
                user.getPassword()
        };
        int retVal = this.jdbcTemplate.update(sql,obj);
        return retVal;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?,password=? where id=?";
        Object[] obj = new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getId()
        };
        int retVal = this.jdbcTemplate.update(sql,obj);
        return retVal;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id=?";
        int retVal = this.jdbcTemplate.update(sql,id);
        return retVal;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public void transfer(String outUser, String inUser, Integer credit) {

        this.jdbcTemplate.update("update user set credit=credit+? where username=?", credit, inUser);
//        int i = 1/0; 用于测试事务是否正常中断回滚
        this.jdbcTemplate.update("update user set credit=credit-? where username=?", credit, outUser);
    }
}
