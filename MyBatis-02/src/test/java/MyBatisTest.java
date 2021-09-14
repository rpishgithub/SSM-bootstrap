import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tech.rpish.po.User;
import tech.rpish.util.MyBatisUtils;

import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findUserByNameAndJobTest() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSession();
        User user = new User();
        user.setUsername("f");
        user.setJob("fo");
        List<User> users = sqlSession.selectList("tech.rpish.mapper.UserMapper.findUserByNameAndJob", user);
        for (User u :
                users) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void findUserByNameOrJobTest() throws Exception {
        SqlSession session = MyBatisUtils.getSession();
        User user = new User();
        user.setUsername("fo");
        user.setJob("f");
        List<User> users = session.selectList("tech.rpish.mapper.UserMapper.findUserByNameOrJob", user);
        for (User u :
                users) {
            System.out.println(u);
        }
        session.close();
    }

    @Test
    public void updateUserTest() throws Exception {
        SqlSession session = MyBatisUtils.getSession();
        User user = new User();
        user.setId(1);
        user.setPhone("220");
        int rows = session.update("tech.rpish.mapper.UserMapper.updateUser", user);
        if (rows > 0) {
            System.out.println("成功修改" + rows + "条数据");
        } else {
            System.out.println("修改失败");
        }
        session.commit();
        session.close();
    }

    @Test
    public void findUserByIdsTest() throws Exception {
        SqlSession session = MyBatisUtils.getSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> users = session.selectList("tech.rpish.mapper.UserMapper.findUserByIds", ids);
        for (User u :
                users) {
            System.out.println(u);
        }
        session.close();
    }

    @Test
    public void findUserByName() {
        SqlSession session = MyBatisUtils.getSession();
        User user = new User();
        user.setUsername("f");
        List<User> users = session.selectList("tech.rpish.mapper.UserMapper.findUserByName", user);
        for (User u : users
        ) {
            System.out.println(u);
        }
        session.close();
    }
}
