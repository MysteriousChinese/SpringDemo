package Model;

import Model.Group;
import Model.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class AppConfig111 {

    @Bean
    public User GetUser(){
        User user = new User();
        System.out.println("++++++++"+user);
        return user;
    }



}
