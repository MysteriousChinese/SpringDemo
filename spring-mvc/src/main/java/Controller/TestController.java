package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class TestController {
    @RequestMapping("Index")
    public ModelAndView Index(){
        ModelAndView view = new ModelAndView();
        /*如果没设置视图解析器，就要这么写view.setViewName("/Views/hello.jsp"); */
        view.setViewName("index");

        return view;
    }

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public ModelAndView Hello(@RequestParam(value = "name",required = false) String btnName){
        ModelAndView view = new ModelAndView();
        /*如果没设置视图解析器，就要这么写view.setViewName("/Views/hello.jsp"); */
        view.setViewName("hello");

        //把数据传给request作用域，jsp页面用el表达式接收
        view.addObject("name",btnName);
        return view;
    }
}
