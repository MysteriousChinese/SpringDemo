package Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/*
*
*
* */
public class ProxyHelper {
    private  Object Target;
    public ProxyHelper(Object target){
        Target = target;
    }

    public Object CreateJDKProxy(){
        return  Proxy.newProxyInstance(Target.getClass().getClassLoader(), Target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前------");
                Object invoke = method.invoke(Target, args);
                System.out.println("方法执行后------");
                return invoke;
            }
        });
    }

    /*
       JDK动态代理 缺点：只能实现接口代理类
    * 必须传类的实例，不能传类Model.Class这种
    * */
    public static <T> T CreateJDKProxy(T target) {
        return  (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前------jdk代理");
                Object invoke = method.invoke(target, args);
                System.out.println("方法执行后------jdk代理");
                return invoke;
            }
        });
    }


    /*
    * 引用cglib动态代理，可以创建类的代理类，而JDK代理只能创建接口的代理类
    * */
    public static <T> T CreateCglibProxy(T target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());

        //注意。这个是cglib库的InvocationHandler，上面那个JDK动态代理的不是
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            /*
            *
            * */
            public Object invoke(Object proxyClass, Method method, Object[] objects) throws Throwable {
                System.out.println("方法执行前------cglib代理");
                Object invoke = method.invoke(target, objects);
                System.out.println("方法执行后------cglib代理");
                return invoke;
            }
        });

        return (T) enhancer.create();
    }

}
