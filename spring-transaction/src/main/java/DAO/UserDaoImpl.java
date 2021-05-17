package DAO;

import Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate _JdbcTemplate;
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        _JdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional //注解的方式 实现aop管理事务
    public int Insert(User user) throws Exception {
        String sql = "insert into user_tb (user_id,user_name,user_password,user_age) values (?,?,?,?)";
        Object[] params ={
                user.getUser_id(),
                user.getUser_name(),
                user.getUser_password(),
                user.getUser_age()
        };
        int row =  _JdbcTemplate.update(sql,params);

        /*这里抛出异常，aop会拦截到，然后回滚*/
        throw new RuntimeException("出错");
        /*return row;*/
    }
}
