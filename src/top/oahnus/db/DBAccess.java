package top.oahnus.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by jackstrom on 2016/5/22.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //通过配置信息获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("top/oahnus/config/Configuration.xml");
        //通过配置信息构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(reader);
        //通过SqlSessionFactory打开一个SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }
}
