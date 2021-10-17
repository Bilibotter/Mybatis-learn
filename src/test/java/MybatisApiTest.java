import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class MybatisApiTest {
    @Test
    public void testQuery() throws IOException {
        String resource = "mybatis-config.xml";
        try(
                Reader reader = Resources.getResourceAsReader(resource);
                SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
        ) {
            User user = session.selectOne("dao.IUserDao.queryUserInfoById", 1L);
            System.out.println(user);
        }
    }

}
