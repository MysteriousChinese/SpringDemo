package Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
* 切面
* 连接点：目标类中的所有不为final的方法都可以理解为连接点
* 切入点：目标类中需要通知或增强的具体某个或多个方法，就是具体拦截哪个或哪些方法
* 通知：就是切面里的用来拦截目标类的方法，DoBefore()这个就是
* */

@Component //植入ioc容器
@Aspect //标记为切面
public class MyAspect {
    public final String POINT_CUT = "execution(* Aspect.SomeServiceImpl.Do*(..))";
    @Before(POINT_CUT)
    public void Before(JoinPoint jp){
        //jp.getArgs();获取切入点的参数列表
        System.out.println("前置通知"+jp.getSignature().getName());
    }

    @AfterThrowing(value = POINT_CUT,throwing = "exception")
    public void Exception(Exception exception){
        System.out.println(String.format("异常通知:%s",exception.getMessage()));
    }

    //最终通知，不管有没有抛出异常
    @After(POINT_CUT)
    public void After(){
        System.out.println("后置通知");
    }

    //在方法return后 触发。但是有异常会跳到catch里，就不会走到return下面了
    @AfterReturning(value = POINT_CUT,returning = "result")
    public void AfterReturning(Object result){
        System.out.println("后置返回通知 ----  返回值："+result);
    }


    /*
    * 整个环绕通知可以包括所有的通知
    * */
    @Around(POINT_CUT)
    public Object Around(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            //Before(pjp);
            System.out.println("环绕 ---- 前置");

            result = pjp.proceed();
        }  catch (Throwable throwable) {
            //Exception(new Exception(throwable));
            System.out.println("环绕 ---- 异常");
        } finally {
            //After();
            System.out.println("环绕 ---- 后置");
        }
        return result;
        //@AfterReturning这个注解相当于在这里执行
        //System.out.println("环绕 ---- 后置返回通知");
    }
}
