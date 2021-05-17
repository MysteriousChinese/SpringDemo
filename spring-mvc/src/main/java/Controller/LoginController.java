package Controller;

import Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
public class LoginController {

    @RequestMapping(value = "page",method = RequestMethod.GET)
    public ModelAndView LoginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public void Login(User user, HttpSession session){
        session.setAttribute("loginUser",user);
        User loginUser = (User)session.getAttribute("loginUser");
        System.out.println(loginUser.getName());
    }
}
