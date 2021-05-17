package org.example;

import Mybatis.Model.User;
import Mybatis.UserDao_Mapper;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void Test(){
        //第一个参数： {映射文件中的命令空间}.{命令id}
        List<User> users = sqlSession.selectList("Mybatis.UserDao_Mapper.Query");
        users.forEach(i -> {
            System.out.println(String.format("名称:%s ,年龄:%s",i.getUserName(),i.getUserAge()));
        });
        String[] s = new String[]{};
    }

    @Test  //基于 代理生成的接口对应 的实现类，直接调用其方法
    public void TestByProxy(){
        UserDao_Mapper mapper = sqlSession.getMapper(UserDao_Mapper.class);

     /*   System.out.println("*******************  HashMap  ********************");
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",19);
        map.put("name","李四");
        User user = mapper.QueryByHash(map);
        System.out.println(String.format("名称:%s ,年龄:%s",user.getUserName(),user.getUserAge()));
        System.out.println("*******************  HashMap  ********************");*/

        System.out.println("*******************  Annotation  ********************");

        User userA = mapper.QueryByAnnotation("五",19);
        if (userA!=null) {
            System.out.println(String.format("名称:%s ,年龄:%s",userA.getUserName(),userA.getUserAge()));
            System.out.println("*******************  Annotation  ********************");
        }




        List<User> users = mapper.Query();
        users.forEach(i -> {
            System.out.println(String.format("名称:%s ,年龄:%s",i.getUserName(),i.getUserAge()));
        });
    }

    @Test
    public void TestQueryByListId(){
        try{
            QueryByListId(null);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void QueryByListId(@NotNull List<String> idList){
       /* UserDao_Mapper mapper = sqlSession.getMapper(UserDao_Mapper.class);
        mapper.QueryByIds(idList);*/
    }

    @Test
    public void TestInsert(){
        UserDao_Mapper mapper = sqlSession.getMapper(UserDao_Mapper.class);
        int rows = mapper.Insert(new User(14,"gqx","0000",26));
        System.out.println(String.format("插入%ss", rows > 0?"成功":"失败"));
    }

    @After
    public void Close(){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
