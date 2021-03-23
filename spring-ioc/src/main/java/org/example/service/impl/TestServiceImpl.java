package org.example.service.impl;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.example.DAO.Interface.ITestDAO;
import org.example.service.Interface.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service //TestServiceImpl实例注册到ioc容器,业务层用@Service
public class TestServiceImpl implements ITestService {

    /**
     * 功能描述:注入对象时使用
     * Autowired:根据属性类型自动装配
     * Qualifier:根据属性名称注入
     * 当有接口多个实现类的时候,不能仅仅通过Autowired自动装配,会识别不了准确的名称
     * 就需要使用Qualifier去指定类名称(首字母小写)
     * @Qualifier("attributeSpring") ;也可以直接写,不用写value
     */
    @Autowired
    @Qualifier("d2")
    ITestDAO testDAO;

    //@Autowired //spring ioc会自动注入容器内关于ITestDAO接口的实例,这种写法不用实现setter方法。配置xml的方式需要实现setter方法
    ITestDAO testDAO2;

    /*
    * @Autowired 配合 @Qualifier(“testDAOImpl”)放在形参的位置 ,以注解的方式 实现构造函数注入
    */
    @Autowired
    public TestServiceImpl(@Qualifier("testDAOImpl") ITestDAO dao, @Value("testsss") String v){
        testDAO2 = dao;
        this.v = v;
    }

    private  String v;
    public void setTestDAO(ITestDAO testDAO) {
        this.testDAO = testDAO;
    }

    @Override
    public void Query() {
        testDAO2.Query();
        System.out.println(v);
    }
}
