package com.example.temaHibernate.Controller;

import com.example.temaHibernate.Service.PersonService;
import com.example.temaHibernate.Service.UserService;
import com.example.temaHibernate.database.Person;
import com.example.temaHibernate.database.User;
import com.example.temaHibernate.Service.UserException;
import com.example.temaHibernate.database.UserRowMapper;
import com.example.temaHibernate.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    UserSession userSession;

    @GetMapping("/register-form")
    public ModelAndView registerAction(@RequestParam("email") String email,
                                       @RequestParam("password1") String password1,
                                       @RequestParam("password2") String password2
                                        ){
        ModelAndView modelAndView=new ModelAndView("register");
        try {
            userService.registerUser(email, password1, password2);
        }catch (UserException e){
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:index.html");
    }
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<User>userList;
        try {
            userList=userService.loginUser(email, password);
        }catch (UserException e){
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        userSession.setId(userList.get(0).getId());
        return new ModelAndView("redirect:dashboard");
    }
    @GetMapping("dashboard")
    public ModelAndView dashboard(){

        ModelAndView modelAndView = new ModelAndView("dashboard");
        if (userSession.getId()<=0){
            return modelAndView;
        }
        return modelAndView;
    }

}
