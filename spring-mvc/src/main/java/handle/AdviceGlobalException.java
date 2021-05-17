package handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/*ControllerAdvice 优先级大于  GlobalExHandle implements HandlerExceptionResolver*/
/*ControllerAdvice 优先级小于  Controller内部 @ExceptionHandler*/
@ControllerAdvice
public class AdviceGlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void NotFoundHandle(){
        System.out.println("NotFoundHandle");
    }
}
