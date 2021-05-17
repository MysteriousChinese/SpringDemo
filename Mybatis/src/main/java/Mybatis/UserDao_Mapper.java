package Mybatis;

import Mybatis.Model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.type.JdbcType;

import java.util.HashMap;
import java.util.List;

public interface UserDao_Mapper {

    /*注解的形式注册映射关系*/
    @Results(id = "user",value =
            {
                    /*id是否为主键*/
                    @Result(property = "UserId",column = "user_id",jdbcType = JdbcType.INTEGER,id = true),
                    @Result(property = "UserName",column = "user_name",jdbcType = JdbcType.VARCHAR),
                    @Result(property = "UserPassword",column = "user_password"),
                    @Result(property = "UserAge",column = "user_age")
            })


    /*绑定上面的映射表*/
    @ResultMap(value = "user")
    List<User> Query();

    User QueryByHash(HashMap<String,Object> map);

    User QueryByAnnotation(@Param("name") String name,@Param("age")int age);

    List<User> QueryByIds(@Param("ids") List<String>UserIds);

    int Insert(User user);


}
