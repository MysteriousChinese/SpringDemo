package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesDemo {


    // @Value注解作用就是读取由spring容器装配信息
    @Value("${user.name1}")
    private String name;
    @Value("${user.gender}")
    private String gender;
    @Value("${user.age}")
    private int age;



    public void Do(){

        System.out.println(String.format("name=%s,age=%s,gender=%s", name, age, gender));
    }
}
