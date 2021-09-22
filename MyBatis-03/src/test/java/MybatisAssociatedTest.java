import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tech.rpish.po.Class;
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

    @Test
    public void findStudentsInClassTest() {
        SqlSession session = MyBatisUtils.getSession();
        Class aClass = session.selectOne("tech.rpish.mapper.ClassMapper.listStudentsInClass", 1);
        System.out.println(aClass);
        session.close();
    }
}
