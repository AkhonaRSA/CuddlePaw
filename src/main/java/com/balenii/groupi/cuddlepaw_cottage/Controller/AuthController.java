//package com.balenii.groupi.cuddlepaw_cottage.Controller;
//
//import com.balenii.groupi.cuddlepaw_cottage.Entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class AuthController {
//
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public ModelAndView register(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public ModelAndView createNewUser(User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public ModelAndView dashboard() {
//        ModelAndView modelAndView = new ModelAndView();
//        return modelAndView;
//    }
//
//    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        return modelAndView;
//    }
//
//}
//
//
//
