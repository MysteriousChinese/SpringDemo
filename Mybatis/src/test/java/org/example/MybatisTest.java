package org.example;

import Mybatis.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest extends AppTest {

    private SqlSession sqlSession;
    @Before  //这个注解 执行运行前的操作
    public void Init() throws IOException {
        //1. xml文件读取成流文件
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");

        //2.利用reader创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //3.获取数据库与mybatis交互的 SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void Test(){
        //第一个参数：映射文件中 命令控件+命令id
        List<User> users = sqlSession.selectList("Mybatis.UserDao_Mapper.Query");
        System.out.println(users);
    }

    @After
    public void Close(){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
