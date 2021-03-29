package org.example;

import org.example.service.Interface.ITestService;
import org.example.service.impl.TestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        //配置文件方式 实例化
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationTest.xml");
        //两种写法一样
        TestServiceImpl testServiceImpl = context.getBean("testServiceImpl", TestServiceImpl.class);
        testServiceImpl.Query();

        ITestService testService = context.getBean("testServiceImpl", ITestService.class);
        testService.Query();

        /*
        * 注解方式 注册ioc：
        * 第一步，给所有需要注册的类上加入注解
        * 第二步，加载配置文件，这个包下所有标记了spring ioc的注解的类或者属性都会被自动注入实例
        *   第一种方法：执行下面这局代码
        *   第二种方法：在xml文件中加入<context:component-scan base-package="org.example" />，扫描这个包下的所有类，然后再加载xml类(new ClassPathXmlApplicationContext("applicationTest.xml");)
        * */
        /*ApplicationContext context1 = new AnnotationConfigApplicationContext("org.example");
        ITestService testServiceImpl = context1.getBean("testServiceImpl", ITestService.class); //注解不用写ID,所有ID默认为类名(首字母小写)
        testServiceImpl.Query();*/


        PropertiesDemo propertiesDemo = context.getBean("propertiesDemo", PropertiesDemo.class);
        propertiesDemo.Do();

    }

}
