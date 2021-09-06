import bean.User;
import dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MyJdbcTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

//        jdbcTemplate.execute(
//                "create table user("+
//                        "id int primary key auto_increment,"+
//                        "username varchar(40),"+
//                        "password varchar(40))"
//        );

    }

    @Test
    public void addUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User();
        user.setUsername("foo");
        user.setPassword("bar");
        int retVal = userDao.addUser(user);
        if(retVal>0){
            System.out.println("成功插入了" + retVal + "条数据");
        }else {
            System.out.println("插入操作执行失败");
        }
    }

    @Test
    public void updateUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User();
        user.setId(1);
        user.setUsername("fooo");
        user.setPassword("barr");
        int retVal = userDao.updateUser(user);
        if(retVal>0){
            System.out.println("成功更新了" + retVal + "条数据");
        }else {
            System.out.println("更新操作执行失败");
        }
    }

    @Test
    public void deleteUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        int retVal = userDao.deleteUser(1);
        if(retVal>0){
            System.out.println("成功删除了" + retVal + "条数据");
        }else {
            System.out.println("删除操作执行失败");
        }
    }

    @Test
    public void findUserById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void findAllUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        List<User> userList = userDao.findAllUser();
        for (User user:userList){
            System.out.println(user);
        }
    }
}
