package org.example;

import DAO.UserDao;
import Model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.Insert(new User(3,"geer","0000",18));
    }

    private static void TestQuery(JdbcTemplate jdbcTemplate){
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap("");

    }
}
