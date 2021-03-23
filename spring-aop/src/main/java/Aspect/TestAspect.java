package Aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-aop.xml");

        /*
        *这里报错，可能是因为xml文件里proxy-target-class="false",又因为SomeServiceImpl继承了接口，所以spring会走JDK代理。
        * 那么应该SomeService someServiceImpl = context.getBean("someServiceImpl", SomeService.class);
        * */
        //SomeService someServiceImpl = context.getBean("someServiceImpl", SomeService.class);
        SomeServiceImpl someServiceImpl = context.getBean("someServiceImpl", SomeServiceImpl.class);
        someServiceImpl.Do();
    }
}
