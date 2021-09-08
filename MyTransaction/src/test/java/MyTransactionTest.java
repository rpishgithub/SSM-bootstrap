import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.rpish.dao.UserDao;

public class MyTransactionTest {
    @Test
    public void MyTransactionTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.transfer("foo","fooo",100);
        System.out.println("Credit Transferred Successfully.");
    }
}
