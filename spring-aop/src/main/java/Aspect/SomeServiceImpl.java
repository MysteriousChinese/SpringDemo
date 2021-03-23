package Aspect;

import org.springframework.stereotype.Component;

@Component
public class SomeServiceImpl implements SomeService {
    @Override
    public String Do() throws Exception {
        try{
            System.out.println("执行do方法");
            throw new Exception("抛出异常");
        }
        catch (Exception ex){

        }
        return  "hello world";
        //AfterReturning是在这句话之后触发的
    }
}
