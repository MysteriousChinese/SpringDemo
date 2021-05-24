package Controller;

import Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RequestMapping("Test")
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


    @RequestMapping(value = "testfreemarker",method = RequestMethod.GET)
    public String TestFreemarker(HttpServletRequest request, ModelMap modelMap){
        System.out.println("TestFreemarker");

        User user= new User(1,"gr",18,"123456");
        modelMap.addAttribute("user",user);
        List<Integer> numbers = Arrays.asList(1,2,3);
        modelMap.addAttribute("list",numbers);



        return "user_ftl";
    }

}
