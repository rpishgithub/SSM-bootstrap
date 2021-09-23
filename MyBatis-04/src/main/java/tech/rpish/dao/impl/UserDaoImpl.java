package tech.rpish.dao.impl;

import org.apache.ibatis.session.SqlSession;
import tech.rpish.dao.UserDao;
import tech.rpish.po.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao  {
    @Override
    public User findUserById(Integer id) {
        return this.getSqlSession().selectOne("tech.rpish.mapper.UserMapper.findUserById", id);
    }
}
