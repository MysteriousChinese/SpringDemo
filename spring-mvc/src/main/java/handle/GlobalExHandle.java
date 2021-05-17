package handle;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        /*instanceof 相当于C#的 is*/
        if(e instanceof RuntimeException){
            System.out.println(String.format("RuntimeException: %s", e.getMessage()));
        }
        else if(e instanceof Exception){
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }

        return  null;
    }
}
