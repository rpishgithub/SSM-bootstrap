import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import tech.rpish.po.User;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findUserByIdTest() throws Exception {
//        读配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        根据配置文件构建SqlSessionFactory Instance
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        公共SqlSessionFactory创建SqlSession Instance
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession执行映射文件中定义的sql,并返回结果
        User user = sqlSession.selectOne("tech.rpish.mapper.UserMapper.findUserById", 1);
//        输出结果
        System.out.println(user);
//        关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void findAllUsersTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("tech.rpish.mapper.UserMapper.findAllUsers");
        for (User user :
                users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUserTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("noone");
        user.setJob("neet");
        user.setPhone("8008208820");
        int rows = sqlSession.insert("tech.rpish.mapper.UserMapper.addUser", user);
        if (rows > 0) {
            System.out.println("成功插入" + rows + "条数据");
        }else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(5);
        user.setJob("not-neet");
        user.setUsername("aFakeName");
        int rows = sqlSession.update("tech.rpish.mapper.UserMapper.updateUser", user);
        if (rows>0){
            System.out.println("成功修改了" + rows + "条数据");
        }else {
            System.out.println("修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.delete("tech.rpish.mapper.UserMapper.deleteUser",4);
        if (rows>0){
            System.out.println("成功删除了" + rows + "条数据");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
