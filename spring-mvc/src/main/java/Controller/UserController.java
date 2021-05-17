package Controller;

import Model.User;
import com.sun.javafx.binding.StringFormatter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*RestController =  @ResponseBody + @Controller*/
/*@Controller*/
@RequestMapping("user")
@RestController
public class UserController {



    /*PostMapping = @RequestMapping(value = "/s/updateUser",method = RequestMethod.POST)*/
    /*@RequestMapping(value = "/s/updateUser",method = RequestMethod.POST)
    @ResponseBody*/
    @PostMapping("/upload")
    public User UpdateUser(@RequestBody User user){
        return user;
    }


    /*不知道.net这么调用get方法可不可以传body数据  http://localhost:8080/user/get_param?id=1&name=mick&age=18 */
    /* 如果类里面还嵌套了类，必须User类里面还有 private Sex sex。那应该 http://localhost:8080/user/get_param?id=1&name=mick&age=18&sex.id=xx  */
    @GetMapping("get_param")
    public User GetUser_Param(User user){
        return user;
    }


    /*这种get方式             http://localhost:8080/user/get?id=1&name=zhangsan&age=18 */
    @GetMapping("get")
    public User GetUser(@RequestParam("id") int id, @RequestParam("name")String name,@RequestParam("age") int age){
        /*User user = new User(id, name, age,"");*/
        return  null;
    }

    /*restful风格 的请求方式   http://localhost:8080/user/get/2/zhangsan/21  上面是参数放在?后面*/
    @GetMapping("get/{id}/{name}/{age}")

    public User GetUser_Restful(@PathVariable("id") int id, @PathVariable("name")String name,@PathVariable("age") int age){
        /*User user = new User(id, name, age,"");*/
        return  null;
    }

    @GetMapping("/init")
    public ModelAndView Init(){
        /*List<User> users = Arrays.asList(new User(1, "张三", 18,"1"),
                new User(2, "李四", 19,"1"),
                new User(3, "王五", 20,"1"),
                new User(4, "马六", 20,"1"));*/
        /*model.addAttribute("userList",users);*/

        ModelAndView view = new ModelAndView();
        /*如果没设置视图解析器，就要这么写view.setViewName("/Views/hello.jsp"); */
      /*  view.setViewName("user");
        view.addObject("userList",users);*/
        return view;
    }


    /**
     * 接收数组 ，注意参数是String name[]  不是String[] name
     * @param name
     */
    @PostMapping("/receiveArray")
    @ResponseBody
    public void ReceiveArray(String name[]){
        System.out.println(name.length);
    }

}
