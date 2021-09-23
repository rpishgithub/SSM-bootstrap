import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tech.rpish.po.Course;
import tech.rpish.utils.MyBatisUtils;

public class MybatisAssociatedTest {
    @Test
    public void listCourseSignUpStudentsTest() {
        SqlSession session = MyBatisUtils.getSession();
        Course course = session.selectOne("tech.rpish.mapper.CourseMapper.findCourseWithStudent", 1);
        System.out.println(course);
        session.close();
    }
}
