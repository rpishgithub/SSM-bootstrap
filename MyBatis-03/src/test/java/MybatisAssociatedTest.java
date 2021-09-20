import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tech.rpish.po.Student;
import tech.rpish.utils.MyBatisUtils;

public class MybatisAssociatedTest {
    @Test
    public void findStudentByIdTest() {
        SqlSession session = MyBatisUtils.getSession();
        Student student = session.selectOne("tech.rpish.mapper.StudentMapper.findStudentById",1);
        System.out.println(student);
        session.close();
    }
}
